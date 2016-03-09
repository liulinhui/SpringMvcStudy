package jgn.study.controller;

import javax.servlet.http.HttpServletRequest;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OtcController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
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


}
