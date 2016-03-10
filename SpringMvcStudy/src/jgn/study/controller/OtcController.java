package jgn.study.controller;

import javax.servlet.http.HttpServletRequest;







import jgn.study.bean.RealUser;
import jgn.study.dao.RealUserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OtcController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private RealUserMapper realuserMapper;
	@RequestMapping(value = "/myproduct")
	public String myproduct(Model model, HttpServletRequest request) {
		logger.info("连上了");
		return "myproduct1.ftl";
	}
	@RequestMapping(value = "/myAsset")
	public String myAsset(Model model, HttpServletRequest request) {
		return "myAsset.ftl";
	}
	@RequestMapping(value = "/myOrder")
	public String myOrder(Model model, HttpServletRequest request) {
		return "myOrder.ftl";
	}
	@RequestMapping(value = "/confirm")
	public String confirm(Model model, HttpServletRequest request) {
		return "confirm.ftl";
	}
	@RequestMapping(value = "/transfer_confirm")
	public String transfer_confirm(Model model, HttpServletRequest request) {
		return "transfer_confirm.ftl";
	}
	@RequestMapping(value = "/AccountRecharge")
	public String AccountRecharge(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");
		String amount = request.getParameter("amount");
		String user_returnUrl = request.getParameter("returnUrl");
		if (user_code == null | user_password == null) {
			
			user_returnUrl = "AccountRecharge.ftl";
		}else {
			RealUser user1 = new RealUser();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_asset(amount);
			realuserMapper.update(user1);
			user_returnUrl = "redirect:/myAsset";
		}
		return user_returnUrl;
	}


}
