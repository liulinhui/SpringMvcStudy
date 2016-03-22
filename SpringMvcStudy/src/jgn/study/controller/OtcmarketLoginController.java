package jgn.study.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jgn.study.bean.Product;
import jgn.study.bean.RealUser;
import jgn.study.dao.ProductMapper;
import jgn.study.dao.RealUserMapper;
import jgn.study.dao.UserMapper;
import jgn.study.common.DES;
import jgn.study.controller.ControllerHelp;

@Controller
public class OtcmarketLoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(OtcmarketLoginController.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RealUserMapper realuserMapper;
	@Autowired
	private ProductMapper productmapper;
	ControllerHelp controllerhellp = new ControllerHelp();
	DES des = new DES();

	@RequestMapping(value = "/buy")
	public String otc_buy(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		String returnUrl;
		String product_code = request.getParameter("product_code");
		String user_code = request.getParameter("id");
		Product product = productmapper.selectByProduct_code(product_code);
		//解密
//		byte[] result = des.encrypt(product.getUser_codeString().getBytes());
//		try {
//			byte[] decryResult = des.decrypt((byte[]) user_code);
//			System.out.println("解密后：" + new String(decryResult));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		product.setUser_codeString(new String(decryResult));		
		logger.info("查询" + product.getProduct_name() + "相应信息===用户代码："+product.getUser_codeString());
		model.addAttribute("product", product);
		if (request.getSession().getAttribute("user_code") != null) {
			returnUrl = "otc_buy.ftl";
		} else {
			returnUrl = "otc_buy_login.ftl";
		}

		return returnUrl;
	}

	@RequestMapping(value = "/sell")
	public String sell(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "otc_sell.ftl";
	}

	@RequestMapping(value = "/protocol")
	public String protocol(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "permission.ftl";
	}

	@RequestMapping(value = "/otc")
	public String otc(Model model, HttpServletRequest request)
			throws ParseException {
		// 取到session值，
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		List<Product> products = new ArrayList<Product>();
		products = productmapper.selectAll();
		for (Product product : products) {
			// 获取剩余到期时间
			String smdate = controllerhellp.Reg_time_();
			String bdate = product.getLimit_time();
			String lasttime = controllerhellp.daysBetween(smdate, bdate);
			product.setLimit_time(lasttime);
			logger.info("===" + product.getProduct_name() + "的剩余时间为："
					+ product.getLimit_time());
			//加密
			byte[] result = des.encrypt(product.getUser_codeString().getBytes());
			product.setUser_codeString(new String(result));	
			logger.info("========遍历选出撤销单=============="+product.getUser_codeString());
			if (product.getUser_codeString().equals(
					request.getSession().getAttribute("user_code"))) {
				product.setState('0');
				logger.info("========遍历选出撤销单==============");
			}
		}
		model.addAttribute("products", products);
		return "index1.ftl";
	}

	@RequestMapping(value = "/account_Login")
	public String account_Login(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String returnUrl = request.getParameter("returnUrl");
		logger.info("下一个跳转的地址" + returnUrl);
		String user_returnUrl = (String) request.getSession().getAttribute(
				"returnUrl");
		if (user_returnUrl == null) {
			request.getSession().setAttribute("returnUrl", returnUrl);
			user_returnUrl = (String) request.getSession().getAttribute(
					"returnUrl");
		}
		logger.info("session里存入的地址："
				+ request.getSession(false).getAttribute("returnUrl"));
		if (user_code == null || user_password == null) {
			logger.info("-----------没有输入用户名密码");
			return "account_Login.ftl";
		} else {
			RealUser realuser = realuserMapper.selectByCode(user_code);
			logger.info("-----后台取到用户数据，检验用户登录");
			if (user_password.equals(realuser.getUser_password())) {
				logger.info("用户：" + user_code + " 已登录！");
				request.getSession().setAttribute("user_code", user_code);
				// user_returnUrl = "redirect:/otc";
			} else if (!user_password.equals(realuser.getUser_password())) {
				user_returnUrl = "Error.ftl";
			}
		}
		return "redirect:" + user_returnUrl;
	}

	@RequestMapping(value = "/account_Reg")
	public String account_Reg(Model model, HttpServletRequest request) {
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String user_returnUrl = request.getParameter("returnUrl");
		String reg_time = controllerhellp.Reg_time();
		logger.info("用户名：" + user_name + "密码：" + user_password + "用户账号"
				+ user_code + "注册时间" + reg_time);
		if (user_code == null || user_password == null || user_name == null) {
			user_returnUrl = "account_Reg.ftl";
		} else {
			RealUser user1 = new RealUser();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_name(user_name);
			user1.setReg_time(reg_time);
			realuserMapper.insert(user1);
			logger.info("注册好了");
			user_returnUrl = "redirect:/account_Login";
		}
		return user_returnUrl;
	}
}
