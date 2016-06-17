package cart.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cart.com.dao.IEstablecimientoDao;
import cart.com.entity.Establecimiento;
import cart.com.service.IEstablecimientoService;

@Service("establecimientoService")
public class EstablecimientoServiceImpl implements IEstablecimientoService {

	@Autowired
	private IEstablecimientoDao establecimientoDao;
	
 

	public boolean guardar(Establecimiento pojo) {
		try		{
			establecimientoDao.guardar(pojo); 			
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
	public boolean actualizar(Establecimiento pojo) {
		try		{
			establecimientoDao.actualizar(pojo);		
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
	public boolean eliminar(Establecimiento pojo) {
		try		{
			establecimientoDao.eliminar(pojo);		
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}	
	}

	
 
	
	public List<Establecimiento> getEstablecimientos() {
		try	{					
			return establecimientoDao.getEstablecimientos();	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}


 
	public Establecimiento getEstablecimiento(int idEstablecimiento) {
		try	{					
			return establecimientoDao.getEstablecimiento(idEstablecimiento);	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}

}
