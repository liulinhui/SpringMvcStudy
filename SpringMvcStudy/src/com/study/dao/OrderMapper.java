package com.study.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.study.bean.Order;



@Component
public interface OrderMapper {
	void insert(Order order);
	List<Order> selectAll(String user_code);
	void deleteOrder(String id);
    void updateOrder(String id);
    Order selectOrderById(String id);
    void updateOrderBuy(Order order);
    void insertOldOrder(Order order);
}
