package com.study.dao;




import java.util.List;

import org.springframework.stereotype.Component;

import com.study.bean.RealUser;

@Component
public interface RealUserMapper {
	RealUser selectByCode(String user_code);
	List<String>selectAllUserList();
	void insert(RealUser realuser);
	void update(RealUser realuser);
	
}
