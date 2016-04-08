package com.study.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.security.util.Password;

import com.study.bean.Product;
import com.study.bean.RealUser;
import com.study.common.DES;
import com.study.common.MD5;
import com.study.common.desToJs;
import com.study.controller.ControllerHelp;
import com.study.dao.ProductMapper;
import com.study.dao.RealUserMapper;
import com.study.dao.UserMapper;

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
	MD5 MD5 = new MD5();

	@RequestMapping(value = "/buy")
	public String otc_buy(Model model, HttpServletRequest request)
			throws Exception {
		if (request.getSession() != null) { // 判断是否登录
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		String returnUrl;
		String product_code = request.getParameter("product_code");
		String user_code = des.decrypt("dfwefrvsefadfereqfdbs",
				request.getParameter("id"));
		logger.info("====解密后的user_code=============" + user_code);
		Product product = productmapper.selectByProduct_code(product_code,
				user_code);
		product.setUser_code(des.encrypt("dfwefrvsefadfereqfdbs", user_code));
		// 计算到期时间
		String smdate = controllerhellp.Reg_time_();
		String bdate = product.getLimit_time();
		String lasttime = controllerhellp.daysBetween(smdate, bdate);
		product.setLimit_time(lasttime);
		logger.info("查询" + product.getProduct_name() + "相应信息===用户代码："
				+ product.getUser_code());
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
	public String otc(Model model, HttpServletRequest request) throws Exception {
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
			// logger.info("===" + product.getProduct_name() + "的剩余时间为："
			// + product.getLimit_time());
			if (product.getUser_code().equals(
					request.getSession().getAttribute("user_code"))) {
				product.setState('0');
				// logger.info("========遍历选出撤销单==============");
			}
			// 加密
			String userString = des.encrypt("dfwefrvsefadfereqfdbs",
					product.getUser_code());
			product.setUser_code(userString);
			// logger.info("啦啦啦啦========加密后的user_code=============="
			// + product.getUser_code());
		}
		model.addAttribute("products", products);
		return "index1.ftl";
	}

	@RequestMapping(value = "/account_Login")
	public String account_Login(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String returnUrl = request.getParameter("returnUrl"); // 从页面传来的URL值
		String user = new String(); // 间接获取到user_code的地址值
		user = request.getParameter("id"); // 购买页面传来的产品主人的id
		if (returnUrl == null) {
			returnUrl = "/otc";
		}
		if (user != null) { // 判断是否下一个页面为购买页面
			returnUrl = returnUrl + "&id=" + user;
			logger.info("====交易页面的跳转地址" + returnUrl);
		}
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
			String key1 = (String) request.getSession().getAttribute("key1"); // 取得密钥
			String key2 = (String) request.getSession().getAttribute("key2");
			String key3 = (String) request.getSession().getAttribute("key3");
			System.out.println(key1 + key2 + key3);
			String Password = realuser.getUser_password();
			desToJs desToJs = new desToJs();
			Password = desToJs.strEnc(Password, key1, key2, key3); // 密码加密
			Password = MD5.GetMD5Iterator(Password, 100);
			if (user_password.equals(Password)) {
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
		if (user_code == null || user_password == null || user_name == null) {
			user_returnUrl = "account_Reg.ftl";
		} else {
			RealUser user1 = new RealUser();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_name(user_name);
			realuserMapper.insert(user1);
			logger.info("用户名：" + user_name + "密码：" + user_password + "用户账号"+ user_code + "注册时间" + reg_time);
			logger.info("注册好了");
			user_returnUrl = "redirect:/account_Login";
		}
		return user_returnUrl;
	}
}
