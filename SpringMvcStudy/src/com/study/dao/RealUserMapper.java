package com.study.dao;




import org.springframework.stereotype.Component;

import com.study.bean.RealUser;

@Component
public interface RealUserMapper {
	RealUser selectByCode(String user_code);
	void insert(RealUser realuser);
	void update(RealUser realuser);
	
}
