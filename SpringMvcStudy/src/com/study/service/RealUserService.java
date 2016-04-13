package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.bean.RealUser;
import com.study.dao.RealUserMapper;

@Service
public class RealUserService {
	@Autowired
	RealUserMapper realusermapper;
	
	public RealUser selectByCode(String user_code){
		RealUser realUser=realusermapper.selectByCode(user_code);
		return realUser;
	}
	
	public void insert(RealUser realuser){
		realusermapper.insert(realuser);
	}
	
	public void update(RealUser realuser){
		realusermapper.update(realuser);
	}
	public List<String> selectAllUsercode(String user_code){
		List<String>strings=realusermapper.selectAllUsercode(user_code);
		return strings;
	}
	
}
