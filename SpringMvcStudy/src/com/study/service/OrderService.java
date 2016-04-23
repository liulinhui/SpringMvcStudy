package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.bean.Order;
import com.study.dao.OrderMapper;

@Service
public class OrderService {
	@Autowired
	OrderMapper orderMapper;
	
	public void insert(Order order){
		orderMapper.insert(order);
	}
	
	public List<Order> selectAll(String user_code){
		List<Order>Orders=orderMapper.selectAll(user_code);
		return Orders;
	};
	
	public void deleteOrder(String id){
		orderMapper.deleteOrder(id);
	}
	
	public void updateOrder(String id){
		orderMapper.updateOrder(id);
	}

}
