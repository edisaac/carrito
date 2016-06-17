package cart.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.type.*;
import cart.com.dao.IProductoDao;
import cart.com.entity.Producto;

@Repository 
@Transactional
public class ProductoDaoImpl extends Dao   implements IProductoDao {
					
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
	@SuppressWarnings("unchecked")
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return  crearCriteria().list();
	}
	@SuppressWarnings("unchecked")
	public List<Producto> getProductosByEstablecimiento(int idEstablecimiento) {
		// TODO Auto-generated method stub
		return  crearCriteria().add(Restrictions.sqlRestriction("id_establecimiento=?", idEstablecimiento,new IntegerType() )).list();
	}
	 
}
