package cart.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cart.com.dao.IProductoDao;
import cart.com.entity.Producto;
import cart.com.service.IProductoService;



@Service("productoService")
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;
	
	public boolean guardar(Producto pojo) {
		try		{
			productoDao.guardar(pojo); 			
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
	public boolean actualizar(Producto pojo) {
		try		{
			productoDao.actualizar(pojo);		
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
	public boolean eliminar(Producto pojo) {
		try		{
			productoDao.eliminar(pojo);		
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
	public Producto getProducto(int idProducto) {
		try	{					
			return productoDao.getProducto(idProducto);	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}

	
	public List<Producto> getProductos() {
		try	{					
			return productoDao.getProductos();	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}
	public List<Producto> getProductosByEstablecimiento(int idEstablecimiento) {
		try	{					
			return productoDao.getProductosByEstablecimiento(idEstablecimiento);
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}
}
