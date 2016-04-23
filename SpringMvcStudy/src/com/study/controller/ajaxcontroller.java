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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.study.bean.FuzzyMatch;
import com.study.bean.Order;
import com.study.bean.Product;
import com.study.common.MD5;
import com.study.common.RSAUtil;
import com.study.common.fuzzyMatch;
import com.study.common.TransPinYin;
import com.study.service.AssetService;
import com.study.service.OldProductService;
import com.study.service.OrderService;
import com.study.service.ProductService;
import com.study.service.RealUserService;

@Controller
public class ajaxcontroller {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	MD5 MD5 = new MD5();
	ControllerHelp controllerhellp = new ControllerHelp();
	@Autowired
	private  RealUserService realUserService;
	@Autowired
	private  ProductService productService;
	@Autowired
	private  AssetService assetService;
	@Autowired
	private  OrderService orderservice;
	@Autowired
	private  OldProductService oldProductService;
	fuzzyMatch fuzzy;
	TransPinYin transPinYinin = new TransPinYin();

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
	@SuppressWarnings("finally")
	@RequestMapping(value = "/codeConfirm")
	@ResponseBody
	public JSONObject codeConfirm(Model model, HttpServletRequest request) {
		String usercode = request.getParameter("usercode");
		String status = new String("noexist");
		try {
			List<String> allUsercode = realUserService
					.selectAllUsercode(usercode);
			if (allUsercode.size() == 1) {
				status = "exist";
			}
		} catch (Exception e) {
			status = "noexist";
		} finally {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", status);
			logger.info("========================================="
					+ jsonObject.toJSONString());
			return jsonObject;
		}

	}

	/* 获取RSA的公钥 */
	@RequestMapping(value = "/getPublicKey")
	@ResponseBody
	public static JSONObject getPublicKey(Model model,
			HttpServletRequest request) throws Exception {
		String pubilcKey;
		pubilcKey = RSAUtil.getPublickModulus();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pubilcKey", pubilcKey);
		return jsonObject;
	}

	/**
	 * 判断购买数量是否超出范围,提交订单
	 */
	@RequestMapping(value = "/confirmAccount")
	@ResponseBody
	public JSONObject confirmAccount(Model model, HttpServletRequest request) {
		int allAccount = Integer.parseInt(request.getParameter("allAccount"));
		String id = request.getParameter("id");
		Double total_money=Double.parseDouble(request.getParameter("total_money"));
		Product product = productService.selectById(id);
		JSONObject jsonObject = new JSONObject();
		if (allAccount > product.getRest_account()) {
			jsonObject.put("result", "false");

		} else if (allAccount <= product.getRest_account()) {
			Order order = new Order();
			order.setId(product.getId());
			order.setBuy_amount(allAccount);
			order.setTotal_money(total_money);
			order.setBuy_time(controllerhellp.Reg_time());
			order.setLimit_time(product.getLimit_time());
			order.setProduct_code(product.getProduct_code());
			order.setPrice(product.getTransfer_price());
			order.setProduct_name(product.getProduct_name());
			order.setReference_income(product.getReference_income());
			order.setRisk(product.getRisk());
			order.setStatus('1');
			order.setUser_code(request.getSession().getAttribute("user_code")
					.toString());
			orderservice.insert(order);
			jsonObject.put("result", "true");
		}
		return jsonObject;
	}
	
	/**
	 * 删除或者取消订单
	 */
	@RequestMapping(value = "/deleteOrder")
	@ResponseBody
	public JSONObject deleteOrder(Model model, HttpServletRequest request){
		String id=request.getParameter("id");
		String result="true";
		try {
			orderservice.deleteOrder(id);
		} catch (Exception e) {
			result="false";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		return jsonObject;
		
	} 
	
	/**
	 * 查询撤销产品
	 */
	@RequestMapping(value = "/choseCancelPro")
	@ResponseBody
	public JSONObject choseCancelPro(Model model, HttpServletRequest request){
		JSONObject jsonObject = new JSONObject();
		String id=request.getParameter("id");
		Product product=productService.selectById(id);
		jsonObject.put("product", product);
		return jsonObject;
	}
	
	/**
	 * 模糊匹配
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/fuzzyMatch")
	@ResponseBody
	public JSONObject fuzzyMatch(Model model, HttpServletRequest request) throws Exception{
		String info=request.getParameter("info");
		JSONObject jsonObject = new JSONObject();
		List<FuzzyMatch>fuzzyMatchs=productService.selectMatchs();
		List<FuzzyMatch>matchs=new ArrayList<FuzzyMatch>();
		if (info.equals("")) {
			return null;
		}
		for(FuzzyMatch fuzzyMatch:fuzzyMatchs){
			String combain=fuzzyMatch.getProduct_code()+transPinYinin.trans2PinYin(fuzzyMatch.getProduct_name())+fuzzyMatch.getProduct_name();
			if (fuzzy.match(info,combain)) {
				matchs.add(fuzzyMatch);
			}
		}
		jsonObject.put("matchs", matchs);
		return jsonObject;
	}
	
	/**
	 * 撤单
	 */
	@RequestMapping(value = "/cancelProduct")
	@ResponseBody
	public JSONObject cancelProduct(Model model, HttpServletRequest request){
		String id=request.getParameter("id");
		String result="true";
		try {
			Product product=productService.selectById(id);
			oldProductService.insertOldProduct(product);
			assetService.updateStatus(id);
			orderservice.updateOrder(id);
			productService.cancel(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			result="false";
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("result", result);
		return jsonObject;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
