package com.niit.mobilebackend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilebackend.model.Cart;
import com.niit.mobilebackend.model.Category;

public class CartDaoImpl implements ICartDao {
	@Autowired
	IProductDao productDao;
	
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
	public boolean save(Cart cart) {
	try {
		
		Session s = sessionFactory.openSession();
		Transaction t= s.beginTransaction();
		s.saveOrUpdate(cart);
		t.commit();
		System.out.println("saving into cart.........impl");
		return true;
		
	}catch(HibernateException e) {
		e.printStackTrace();
		return false;
		
	}
		
	}

	public boolean update(Cart cart) {
		try {
			
			Session s = sessionFactory.openSession();
			Transaction t= s.beginTransaction();
			s.update(cart);
			t.commit();
			
			return true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
			
		}
	
		
	}

	public boolean delete(Cart cart) {
		try {
			Session s=sessionFactory.openSession();
			Transaction tx=s.beginTransaction();
			s.delete(cart);
            tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	public Cart getbyid(int id) {
		try {
		
		String hql="from Cart where id="+id;
		Session s=sessionFactory.openSession();
		
		Transaction tx=s.beginTransaction();
		org.hibernate.Query query =s.createQuery(hql);
		
		List<Cart>list=query.list();
		if(list==null)
		{
			return null;
		}
		else
		{
			System.out.println("getting by id product ,.......in impl");
			return list.get(0);
		}
}catch(HibernateException e) {
	e.printStackTrace();
	return null;
}
	}

	public Cart get(int id, int Cartid) {
	System.out.println("inside get productByName daoimpl");
	System.out.println("id" + id);
	String hql="from Cart where id="+id+ "'" +"and id="+ Cartid;
	Query query =sessionFactory.openSession().createQuery(hql);
	List<Cart> list=query.list();
	if(list==null || list.isEmpty()) {
		return null;
		
	}
	else
	{
		return list.get(0);
	}
		

	}
@Transactional
	public List<Cart> listcartproducts(int id) {
		try {
			
			String hql="from Cart where id="+id;
			Session s=sessionFactory.openSession();
			
			Transaction tx=s.beginTransaction();
			org.hibernate.Query query =s.createQuery(hql);
			
			List<Cart>all=query.list();
			tx.commit();
			System.out.println("listing cart products.........in impl");
			return all;
			
	}catch(HibernateException e) {
		e.printStackTrace();
		return null;
	}

		
	}

	public int totalproducts(int id) {
		try {
		
		String hql="from Cart where userid="+id;
		Session s=sessionFactory.openSession();
		
		Transaction tx=s.beginTransaction();
		org.hibernate.Query query =s.createQuery(hql);
		
		List<Cart>all=query.list();
		tx.commit();
		int k =0;
		for(Cart temp: all) {
			k=k+1;
			
		}
		System.out.println("total products in");
		return k;
      }catch(HibernateException e) {
	 e.printStackTrace();
	return 0;
}
}

	public int totalprice(int id) {
		try {
			
			String hql="from Cart where userid="+id;
			Query query =sessionFactory.openSession().createQuery(hql);
			
		List<Cart>all=query.list();
		float k=0;
		for (Cart temp:all) {
			k=k +temp.getPrice();
		}
		return (int) k;
	      }catch(HibernateException e) {
		 e.printStackTrace();
		return 0;
	}
		
		
	}

	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
