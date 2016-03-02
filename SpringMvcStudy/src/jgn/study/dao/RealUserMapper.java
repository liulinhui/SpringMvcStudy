package jgn.study.dao;

import jgn.study.bean.RealUser;


import org.springframework.stereotype.Component;

@Component
public interface RealUserMapper {
	RealUser selectByCode(String user_code);
	void insert(RealUser realuser);
	
}
