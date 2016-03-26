package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.study.bean.Product;


@Component
public interface ProductMapper {
	Product selectByProduct_code(@Param("product_code")String product_code,@Param("user_code")String user_code);
	List<Product> selectAll();
	void insert(Product product);
}
