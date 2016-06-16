package cart.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.com.dao.IOrdenDao;
import cart.com.dao.IProductoDao;
import cart.com.entity.Orden;
import cart.com.service.IOrdenService;

@Service("ordenService")
public class OrdenServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenDao ordenDao;
	
	public boolean guardar(Orden pojo) {
		try		{
			ordenDao.guardar(pojo); 			
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
	public boolean actualizar(Orden pojo) {
		try		{
			ordenDao.actualizar(pojo); 			
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	 
	}

	
	public boolean eliminar(Orden pojo) {
		try		{
			ordenDao.eliminar( pojo); 			
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}
	}

	
	public Orden getOrden(int idOrden) {
		try	{					
			return ordenDao.getOrden(idOrden);	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}

}
