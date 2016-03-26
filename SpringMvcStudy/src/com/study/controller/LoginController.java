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
//			User user1=new User();
//			user1.setName(name);
//			user1.setPassword(password);
//			userMapper.insert(user1);
			User user = userMapper.selectByName(name);
			if (password.equals(user.getPassword())) {
				logger.info("用户：" + name + " 已登录！");
//				request.getSession().setAttribute("name", name);
				returnUrl = "redirect:/otc";
			}
		}

		return returnUrl;
	}
	
	

}
