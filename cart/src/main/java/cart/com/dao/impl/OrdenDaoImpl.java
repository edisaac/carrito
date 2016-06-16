package cart.com.dao.impl;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cart.com.dao.IOrdenDao;
import cart.com.entity.Orden;
import cart.com.entity.Producto;

@Repository("ordenDao")
public class OrdenDaoImpl extends Dao implements IOrdenDao {
	
	public void guardar(Orden pojo) {
		// TODO Auto-generated method stub
		//Transaction tx = null;
		//tx= getSession().beginTransaction();
		getSession().save(pojo);
		getSession().flush();
		getSession().close();
		//tx.commit();
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
		return (Orden)getSession().get(Producto.class, idOrden);
		 
	}

}
