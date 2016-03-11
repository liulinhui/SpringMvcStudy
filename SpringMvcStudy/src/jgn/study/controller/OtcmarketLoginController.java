package jgn.study.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;
import com.sun.net.httpserver.HttpContext;

import jgn.study.bean.Product;
import jgn.study.bean.RealUser;
import jgn.study.bean.User;
import jgn.study.dao.ProductMapper;
import jgn.study.dao.RealUserMapper;
import jgn.study.dao.UserMapper;

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

	@RequestMapping(value = "/buy")
	public String otc_buy(Model model, HttpServletRequest request) {
		String returnUrl;
		String product_code = request.getParameter("product_code");
		Product product = productmapper.selectByProduct_code(product_code);
		logger.info("啦啦啦啦啦阿里" + product.getProduct_name());
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
		return "otc_sell.ftl";
	}

	@RequestMapping(value = "/protocol")
	public String protocol(Model model, HttpServletRequest request) {
		return "permission.html";
	}

	@RequestMapping(value = "/otc")
	public String otc(Model model, HttpServletRequest request) {
		// 取到session值，
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		// Product product = productmapper.selectByProduct_code("2431242");
		// logger.info("h哈哈哈哈");
		// String product_name = product.getProduct_name();

		// model.addAttribute("product_name", product_name);
		// logger.info(product_name + "查询成功");
		List<Product> products = new ArrayList<Product>();
		products = productmapper.selectAll();
		model.addAttribute("products", products);
		return "index1.ftl";
	}

	@RequestMapping(value = "/account_Login")
	public String account_Login(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String user_returnUrl = request.getParameter("returnUrl");
		if (user_code == null | user_password == null) {
			logger.info("啦啦啦啦啦啦");
			user_returnUrl = "account_Login.ftl";
		} else {
			RealUser realuser = realuserMapper.selectByCode(user_code);
			logger.info("lalalalala");
			if (user_password.equals(realuser.getUser_password())) {
				logger.info("用户：" + user_code + " 已登录！");
				request.getSession().setAttribute("user_code", user_code);
				user_returnUrl = "forward:/otc";
			} else if (!user_password.equals(realuser.getUser_password())) {
				user_returnUrl = "Error.ftl";
			}
		}
		return user_returnUrl;
	}

	@RequestMapping(value = "/account_Reg")
	public String account_Reg(Model model, HttpServletRequest request) {
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String user_returnUrl = request.getParameter("returnUrl");
		logger.info(user_name + user_password + user_code);
		if (user_code == null | user_password == null | user_name == null) {
			user_returnUrl = "account_Reg.ftl";
		} else {
			RealUser user1 = new RealUser();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_name(user_name);
			realuserMapper.insert(user1);
			logger.info("注册好了");
			user_returnUrl = "redirect:/account_Login";
		}
		return user_returnUrl;
	}
}
