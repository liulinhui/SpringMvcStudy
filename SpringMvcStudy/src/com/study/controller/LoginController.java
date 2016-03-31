package com.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;
import com.study.bean.User;
import com.study.common.desToJs;
import com.study.dao.UserMapper;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/index")
	public String login(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String returnUrl = request.getParameter("returnUrl");
		if (StringUtils.isNullOrEmpty(returnUrl)) {
			returnUrl = "Login1.ftl";
		}
		if (name != null && password != null) {
			desToJs desToJs=new desToJs();
			password=desToJs.strDec(password, "53", "2", "3");
			logger.info("================解密后的密码"+password);
			User user = userMapper.selectByName(name);
			if (password.equals(user.getPassword())) {
				logger.info("用户：" + name + " 已登录！");
				returnUrl = "redirect:/otc";
			}
		}

		return returnUrl;
	}
	
	

}
