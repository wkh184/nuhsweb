package com.nuhs.gcto.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuhs.gcto.controller.WebController;

import java.lang.invoke.MethodHandles;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static SessionFactory sessionFactory = buildSessionFactory();
	private static StandardServiceRegistry registry;

	private static SessionFactory buildSessionFactory() {

		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder()
						.configure()
						.build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("buildSessionFactory Exception", e);
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;		
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}