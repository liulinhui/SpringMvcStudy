package com.study.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.study.bean.FuzzyMatch;
import com.study.bean.Product;


@Component
public interface ProductMapper {
	List<Product> selectAll();
	void insert(Product product);
	Product selectById(String id);
	void cancel(String id);
	List<FuzzyMatch>selectMatchs();
	void update(Product product);
}
