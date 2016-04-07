package com.study.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.study.common.MD5;
import com.study.dao.RealUserMapper;

@Controller
public class ajaxcontroller {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	MD5 MD5 = new MD5();
	ControllerHelp controllerhellp = new ControllerHelp();
	@Autowired
	private RealUserMapper realuserMapper;

	/* 登录页面请求产生密钥 */
	@RequestMapping(value = "/ajaxAccount_login")
	@ResponseBody
	public JSONObject ajaxAccount_login(Model model, HttpServletRequest request) {
		String timeString = controllerhellp.Reg_time();
		String key1 = MD5.GetMD5Iterator(
				timeString.substring(0, 5) + Math.random() * 10000, 5); // 获取随机密钥key1，key2，key3
		String key2 = MD5.GetMD5Iterator(
				timeString.substring(5, 11) + Math.random() * 10000, 5); // 密钥用md5加密防止被人发现规律
		String key3 = MD5.GetMD5Iterator(
				timeString.substring(11, 19) + Math.random() * 10000, 5);
		request.getSession().setAttribute("key1", key1); // 将密钥存入session里面
		request.getSession().setAttribute("key2", key2);
		request.getSession().setAttribute("key3", key3);
		JSONObject jsonObject = new JSONObject(); // 创建session
		jsonObject.put("key1", key1);
		jsonObject.put("key2", key2);
		jsonObject.put("key3", key3);
		return jsonObject;
	}

	          /* 判断用户名是否重复 */
	@RequestMapping(value = "/codeConfirm")
	@ResponseBody
	public JSONObject codeConfirm(Model model, HttpServletRequest request) {
		String usercode=request.getParameter("usercode");
		String status=new String("null");
		List<String>usercodelist=realuserMapper.selectAllUserList();
		logger.info("==============usercodelist"+usercodelist.size());
        for (int i = 0; i < usercodelist.size(); i++) {
			if (usercode.equals(usercodelist.get(i))) {
				status="exist";
				break;
			}
		}
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result", status);
        return jsonObject;
	}

}
