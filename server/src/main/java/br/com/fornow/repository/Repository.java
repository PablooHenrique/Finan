package br.com.fornow.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Repository {
	
	private static Repository applicationInstance;
	private SessionFactory sessionFactory; 
	
	public Repository() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static synchronized Repository getInstance() {
        if (applicationInstance == null) {
            applicationInstance = new Repository();
        }

        return applicationInstance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
