package com.study.dao;

import org.springframework.stereotype.Component;

import com.study.bean.User;

@Component
public interface UserMapper {
	User selectByName(String name);
	void insert(User user);
}
