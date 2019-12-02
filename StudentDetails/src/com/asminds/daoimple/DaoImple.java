package com.asminds.daoimple;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.asminds.dao.Dao;
import com.asminds.pojo.Student;
import com.asminds.pojo.UpdatePojo;

public class DaoImple implements Dao {

	
	public void insert(Student s) {
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(s);
		System.out.println("inserted successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}


	public List<Student> search(Student h) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factroy = cfg.buildSessionFactory();
		Session session = factroy.openSession();
		Query qry = session.createQuery("from Student where id=" + h.getId());
		List l = qry.list();
		System.out.println("im in search hibernate ");
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Student pp = (Student) it.next();

			System.out.println(pp.getId());
			System.out.println(pp.getName());
			System.out.println(pp.getAddress());
		}

		session.close();
		factroy.close();
		return l;

		
		
	
	}



	public List<Student> getallStudentpojo() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		System.out.println(" Going to get the emp impl");
		List<Student> list = session.createQuery("from Student e").list();

		System.out.println(list.size());

		session.close();
		factory.close();
		return list;

		
		
		
	}
	public void deleteEmployee(Integer id) {
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.load(Student.class, new Integer(id));
		Student p = (Student) o;

		Transaction tx = session.beginTransaction();
		session.delete(p);
		System.out.println("Object Deleted successfully.....!!");
		tx.commit();
		session.close();
		factory.close();

		
	}



	public List<Student> updateDAO(UpdatePojo s) {
		
		System.out.println("im in update method");
		System.out.println(s.getUpdatefield());
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
			Query q = ss.createQuery("from Student where id=" + s.getUpdatefield());
		List l = q.list();
		System.out.println("total number of records" + l.size());
		Iterator i = l.iterator();
		ss.close();
		sf.close();
		return l;

	}


	
	public Boolean updateemployeeDao(Student loo) {
				
		System.out.println("im in updateall method");
		System.out.println(loo.getAddress());
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("UPDATE Student set name = :name,address = :address "  +  "WHERE id = :id");
		q.setParameter("name", loo.getName());
		q.setParameter("address", loo.getAddress());
		q.setParameter("id", loo.getId());
		int result = q.executeUpdate();
		System.out.println("rows affected" + result);
		tx.commit();
		s.close();
		sf.close();
		return true;
	}

		
	}


