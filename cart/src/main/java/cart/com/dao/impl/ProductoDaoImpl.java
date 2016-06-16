package cart.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.type.*;
import cart.com.dao.IProductoDao;
import cart.com.entity.Producto;

@Repository 
@Transactional
public class ProductoDaoImpl   implements IProductoDao {
	
 
		 
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
				
	public void guardar(Producto pojo) {
		// TODO Auto-generated method stub
		getSession().save(pojo);
	}

	
	public void actualizar(Producto pojo) {
		// TODO Auto-generated method stub
		getSession().update(pojo);
	}

	
	public void eliminar(Producto pojo) {
		// TODO Auto-generated method stub
		getSession().delete(pojo);
	}

	
	public Producto getProducto(int idProducto) {
		// TODO Auto-generated method stub
		
		return (Producto)getSession().get(Producto.class, idProducto);
	}

	public Criteria crearCriteria(){
		return getSession().createCriteria(Producto.class);
	}
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return  crearCriteria().list();
	}
	 
	public List<Producto> getProductosByEstablecimiento(int idEstablecimiento) {
		// TODO Auto-generated method stub
		return  crearCriteria().add(Restrictions.sqlRestriction("id_establecimiento=?", idEstablecimiento,new IntegerType() )).list();
	}
	 
}
