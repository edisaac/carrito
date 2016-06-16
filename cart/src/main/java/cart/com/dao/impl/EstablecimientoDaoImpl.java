package cart.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cart.com.dao.IEstablecimientoDao;
import cart.com.entity.Establecimiento;
 
@Repository 
@Transactional
public class EstablecimientoDaoImpl implements IEstablecimientoDao   {

		 
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
			
	public void guardar(Establecimiento pojo) {
		// TODO Auto-generated method stub
		getSession().save(pojo);
		getSession().persist(pojo);
	}

	
	public void actualizar(Establecimiento pojo) {
		// TODO Auto-generated method stub
		getSession().update(pojo);
	}

	
	public void eliminar(Establecimiento pojo) {
		// TODO Auto-generated method stub
		getSession().delete(pojo);
	}

	
	public Establecimiento getEstablecimiento(int idEstablecimiento) {
		// TODO Auto-generated method stub
		return (Establecimiento)getSession().get(Establecimiento.class, idEstablecimiento);
	}

	public Criteria crearCriteria(){
		return getSession().createCriteria(Establecimiento.class);
	}
	
	 
	@SuppressWarnings("unchecked")
	public List<Establecimiento> getEstablecimientos() {
		// TODO Auto-generated method stub
		return    crearCriteria().list();
	}

}
