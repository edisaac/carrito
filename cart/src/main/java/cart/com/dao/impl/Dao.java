package cart.com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Dao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public Session getSession() throws HibernateException {
    	Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		return session;
    }
}
