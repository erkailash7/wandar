package com.wander.wander.project.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;

public class HibernateUtil {

	 private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();
	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                
	               settings.put(Environment.DRIVER, "org.h2.Driver");
	                
	             //   settings.put(Environment.DRIVER, "org.hsqldb.jdbc.JDBCDriver");
	                
	                settings.put(Environment.URL, "jdbc:h2:mem:testdb  "); 
	                
	             // settings.put(Environment.URL, " jdbc:hsqldb:mem:myDb"); 
	                
	                settings.put(Environment.USER, "sa");
	                settings.put(Environment.PASS, "sa");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
	                
	              //settings.put(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
	                
	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
	                configuration.setProperties(settings);
	                configuration.addAnnotatedClass(User.class);
	                configuration.addAnnotatedClass(Note.class);
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
}
