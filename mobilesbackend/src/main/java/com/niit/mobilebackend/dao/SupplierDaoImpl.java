package com.niit.mobilebackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilebackend.model.Supplier;

@Repository("supplierDao")
@Transactional

public class SupplierDaoImpl implements ISupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorUpdate(Supplier supplier) {
		try
		{
			sessionFactory.openSession().saveOrUpdate(supplier);
			return true;
		}catch(Exception e)
		{
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Supplier supplier) {
		try
		{
			sessionFactory.openSession().delete(supplier);
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	public Supplier get(int id) {
		try
		{
			return sessionFactory.openSession().createQuery("from Supplier where supplierid=:id",Supplier.class).setParameter("id",id).getSingleResult();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public List<Supplier> list() {
		try
		{
			return sessionFactory.openSession().createQuery("from Supplier",Supplier.class).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}
	

}
