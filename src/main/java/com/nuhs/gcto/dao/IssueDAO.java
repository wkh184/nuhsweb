package com.nuhs.gcto.dao;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nuhs.gcto.db.HibernateUtil;
import com.nuhs.gcto.model.Issue;

public class IssueDAO {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	static public Integer addIssue(Issue issue) {
		logger.debug("addIssue");
		Integer issueID = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
			issue.setCreatedDT(currentTimestamp);
			issue.setUpdatedDT(currentTimestamp);
			issueID = (Integer)session.save(issue);
			tx.commit();
		}catch (Exception e) {
			logger.error("addIssue Exception", e);
			e.printStackTrace(); 
			if (tx!=null) {
				tx.rollback();
			}
		} finally {
			logger.debug("addIssue close");
			session.close();
		}
		return issueID;
	}
	
	static public List getAllIssues() {
		logger.debug("getAllIssues");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List issues = null;
		try {
			tx = session.beginTransaction();
			issues = session.createQuery("FROM Issue").list(); 
			tx.commit();
		}catch (Exception e) {
			logger.debug("getIssues Exception", e);
			e.printStackTrace(); 
			if (tx!=null) {
				tx.rollback();
			}
		} finally {
			logger.debug("getIssues close");
			session.close();
		}
		return issues;
	}

	//TODO logic for getting the top issues for dashboard
	static public List getTopIssues(int size) {
		logger.debug("getTopIssues");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List issues = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Issue");
			query.setMaxResults(size);
			
			issues = query.list(); 
			tx.commit();
		}catch (Exception e) {
			logger.error("getTopIssues Exception", e);
			e.printStackTrace(); 
			if (tx!=null) {
				tx.rollback();
			}
		} finally {
			logger.debug("getTopIssues close");
			session.close();
		}
		return issues;
	}
}
