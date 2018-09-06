package com.nuhs.gcto.dao;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nuhs.gcto.db.HibernateUtil;
import com.nuhs.gcto.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAO {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public User findByAdid(String adid) {
		logger.debug("findByAdid");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			user = (User) session.createQuery("FROM User WHERE adid=?").setParameter(0, adid).list(); 
			tx.commit();
		}catch (Exception e) {
			logger.debug("findByAdid Exception", e);
			e.printStackTrace(); 
			if (tx!=null) {
				tx.rollback();
			}
		} finally {
			logger.debug("findByAdid close");
			session.close();
		}
		return user;
		
	}
}
