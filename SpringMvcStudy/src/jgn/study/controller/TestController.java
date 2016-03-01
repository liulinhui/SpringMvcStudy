package jgn.study.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/{reportDate}_{serial_no}.html")
	public String personal(@PathVariable String reportDate, @PathVariable String serial_no) {
		System.out.println("reportDate: " + reportDate);
		System.out.println("serial_no: " + serial_no);
		return "../404.html";
	}
	
	@GET
	@RequestMapping("/json")
	@ResponseBody
	public List<String> json(HttpServletRequest request) {
		System.out.println("访问了");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		
		List<String> list = new ArrayList<String>();
		list.add(year);
		list.add(month);
		return list;
	}
}
