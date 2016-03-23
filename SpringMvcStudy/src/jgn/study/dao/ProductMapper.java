package jgn.study.dao;

import java.util.List;

import jgn.study.bean.Product;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface ProductMapper {
	Product selectByProduct_code(@Param("product_code")String product_code,@Param("user_code")String user_code);
	List<Product> selectAll();
	void insert(Product product);
}
