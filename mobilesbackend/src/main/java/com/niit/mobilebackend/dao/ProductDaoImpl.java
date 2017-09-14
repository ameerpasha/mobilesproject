package com.niit.mobilebackend.dao;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilebackend.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements IProductDao {
@Autowired
SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory2) {
	// TODO Auto-generated constructor stub
}
	public void saveProduct(Product product) {
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.save(product);
		t.commit();
		
		// TODO Auto-generated method stub

	}

}
