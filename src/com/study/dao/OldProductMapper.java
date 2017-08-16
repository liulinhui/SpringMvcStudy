package com.study.dao;

import org.springframework.stereotype.Component;

import com.study.bean.Product;

@Component
public interface OldProductMapper {
	void insertOldProduct(Product oldProduct);

}
