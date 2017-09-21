package com.niit.mobilebackend.dao;

import java.util.List;

import com.niit.mobilebackend.model.Product;

public interface IProductDao {
	public void saveProduct(Product product);
	public List<Product> list();

}
