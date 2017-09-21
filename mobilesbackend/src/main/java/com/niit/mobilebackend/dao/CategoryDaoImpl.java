package com.niit.mobilebackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.mobilebackend.model.Category;
import com.niit.mobilebackend.model.Supplier;
import com.niit.mobilebackend.model.User;

public class CategoryDaoImpl implements ICategoryDao{
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory2) {
		// TODO Auto-generated constructor stub
	}

	public void saveCategory(Category category) {
		
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(category);
		tx.commit();
		s.clear();
	}

	public List<Category> getCategories() {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From Category");
		List<Category>cat =query.list();
		if(cat!=null)
		{
			return cat;
		}
		else
		{
			System.out.println("list empty");
			return null;
		}
	}

	public boolean delete(Category category) {
		try
		{
			sessionFactory.openSession().delete(category);
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	public Category get(int id) {
		try
		{
			return sessionFactory.openSession().createQuery("from Category where catid=:id",Category.class).setParameter("id",id).getSingleResult();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
		
	}
	

}
