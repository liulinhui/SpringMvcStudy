package jgn.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

import jgn.study.bean.RealUser;
import jgn.study.bean.User;
import jgn.study.dao.RealUserMapper;
import jgn.study.dao.UserMapper;

@Controller
public class OtcmarketLoginController {
	private static final Logger logger = LoggerFactory.getLogger(OtcmarketLoginController.class);
	@Autowired
	private UserMapper userMapper;
	private RealUserMapper realuserMapper;
	
	
	@RequestMapping(value = "/buy")
	public String otc_buy(Model model, HttpServletRequest request) {
		
		
		return "otc_buy_3.html";
	}
	
	@RequestMapping(value = "/sell")
	public String sell(Model model, HttpServletRequest request) {
		
		
		return "otc_sell.html";
	}
	@RequestMapping(value = "/otc")
	public String otc(Model model, HttpServletRequest request) {
		
		
		return "index1.ftl";
	}
	@RequestMapping(value = "/account_Login")
	public String account_Login(Model model, HttpServletRequest request) {
		
		
		return "account_Login.ftl";
	}
	@RequestMapping(value = "/account_Reg")
	public String account_Reg(Model model, HttpServletRequest request){
		String user_code = request.getParameter("user_name");
		String user_password = request.getParameter("password");
		String user_returnUrl = request.getParameter("returnUrl");
		logger.info("啦啦啦啦啦啦啦啦啦");
		if (user_code == null | user_password == null) {
			user_returnUrl = "account_Reg.ftl";
			logger.info("没有输名字");
		}
		else{
			RealUser user1=new RealUser();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			
			user1.setUser_name("lalalala");
			logger.info("操你大爷"+user1.getUser_code()+user1.getUser_name()+user1.getUser_password());
			
			realuserMapper.insert(user1);
			logger.info("插入完成");
			user_returnUrl = "redirect:/account_Login";
		}
			
		logger.info("他妈的");	
				
		return user_returnUrl;
	}




	}


