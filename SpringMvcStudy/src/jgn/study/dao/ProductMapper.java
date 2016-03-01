package jgn.study.dao;

import java.util.List;

import jgn.study.bean.Product;

import org.springframework.stereotype.Component;


@Component
public interface ProductMapper {
	Product selectByName(String name);
	List<Product> selectAll(Product product);
	void insert(Product product);
}
