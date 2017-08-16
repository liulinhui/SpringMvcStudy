package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.study.bean.Product;
import com.study.dao.OldProductMapper;

@Component
public class OldProductService{
	@Autowired
	OldProductMapper oldProductMapper;
	public void insertOldProduct(Product oldProduct){
		oldProductMapper.insertOldProduct(oldProduct);
	}

}
