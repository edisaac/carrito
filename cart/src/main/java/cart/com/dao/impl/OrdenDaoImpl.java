package cart.com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cart.com.dao.IOrdenDao;
import cart.com.entity.Orden;
import cart.com.entity.Producto;

@Repository
@Transactional
public class OrdenDaoImpl extends Dao  implements IOrdenDao {

 
	 
		 
	
	public void guardar(Orden pojo) {
	 
		getSession().save(pojo);
 
	}
	
	public void actualizar(Orden pojo) {
		// TODO Auto-generated method stub
		getSession().update(pojo);
	}
	
	public void eliminar(Orden pojo) {
		// TODO Auto-generated method stub
		getSession().delete(pojo); 
	}
	 
	public Orden getOrden(int idOrden) {
		return (Orden)getSession().get(Orden.class, idOrden);
		 
	}

}
