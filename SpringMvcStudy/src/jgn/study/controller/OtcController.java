package jgn.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "myproduct1.ftl";
	}
	@RequestMapping(value = "/myAsset")
	public String myAsset(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		RealUser user=new RealUser();
		user=realuserMapper.selectByCode((String)request.getSession().getAttribute("user_code"));
		String time=user.getReg_time().substring(0, 19);
		user.setReg_time(time);
		logger.info("========注册时间："+user.getReg_time()+"===========");
		model.addAttribute("user",user);
		logger.info("=================用户"+user.getUser_name()+"信息采集成功===============");
		return "myAsset.ftl";
	}
	@RequestMapping(value = "/myOrder")
	public String myOrder(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "myOrder.ftl";
	}
	@RequestMapping(value = "/confirm")
	public String confirm(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "confirm.ftl";
	}
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			String user_code=null;
			request.getSession().setAttribute("user_code",user_code);
			request.getSession().setAttribute("returnUrl",user_code);
			logger.info("----登录信息已经被清除----");
		}
		return "redirect:/otc";
	}
	@RequestMapping(value = "/transfer_confirm")
	public String transfer_confirm(Model model, HttpServletRequest request) {
		if (request.getSession() != null) {
			model.addAttribute("reg",
					request.getSession().getAttribute("user_code"));
		}
		return "transfer_confirm.ftl";
	}
	@RequestMapping(value = "/AccountRecharge")
	public String AccountRecharge(Model model, HttpServletRequest request) {
		String user_password = request.getParameter("user_password");
		String user_code = request.getParameter("user_code");		
		String user_returnUrl = request.getParameter("returnUrl");
		if (user_code == null | user_password == null) {
			
			user_returnUrl = "AccountRecharge.ftl";
		}else {
			Integer amount = Integer.parseInt(request.getParameter("amount"),10);
			System.out.println("----------输入充值的数量为："+amount);
			RealUser user1 = new RealUser();
			int oldAsset=realuserMapper.selectByCode(user_code).getUser_asset();
			user1.setUser_code(user_code);
			user1.setUser_password(user_password);
			user1.setUser_asset(amount+oldAsset);
			realuserMapper.update(user1);
			user_returnUrl = "redirect:/myAsset";
		}
		return user_returnUrl;
	}


}
