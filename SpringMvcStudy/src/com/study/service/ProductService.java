package com.study.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.bean.Product;
import com.study.dao.ProductMapper;


@Service
public class ProductService {
	@Autowired
	ProductMapper productmapper;
//	@Cacheable(value="myCache",key="#root.targetClass + #root.methodName")
	public List<Product> selectAll(){
		List<Product>products=productmapper.selectAll();
		return products;
	};
	
	public void insert(Product product){
		productmapper.insert(product);
	}

	public Product selectById(@Param("id")String id) {
		Product product=productmapper.selectById(id);
		return product;
	}
	public void cancel(String id){
		productmapper.cancel(id);
	}
}
