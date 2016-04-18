package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.bean.Order;
import com.study.dao.OrderMapper;

@Service
public class OrederService {
	@Autowired
	OrderMapper orderMapper;
	
	public void insert(Order order){
		orderMapper.insert(order);
	}
	
	public List<Order> selectAll(String user_code){
		List<Order>Orders=orderMapper.selectAll(user_code);
		return Orders;
	};

}
