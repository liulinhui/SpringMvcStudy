package jgn.study.controller;

import javax.servlet.http.HttpServletRequest;

import jgn.study.bean.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

public class OtcController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value = "/myproduct")
	public String login(Model model, HttpServletRequest request) {
		
		return "myproduct.html";
	}

}
