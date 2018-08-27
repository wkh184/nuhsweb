package com.nuhs.gcto.db;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuhs.gcto.model.IAuditDBRecord;

public class DiscoveryInterceptor extends EmptyInterceptor {
	
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public DiscoveryInterceptor() {
		// TODO Auto-generated constructor stub
	}

	public void preFlush(Iterator entities) {
		while(entities.hasNext()) {
			Object obj = entities.next();
			logger.debug("preFlush:entity = {}", obj.getClass());
			if(obj instanceof IAuditDBRecord) {
				logger.debug("preFlush:entity ID = {}", ((IAuditDBRecord)obj).getId());				
			}
		}
	}

}
