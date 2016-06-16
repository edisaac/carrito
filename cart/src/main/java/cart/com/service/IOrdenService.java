package cart.com.service;

import cart.com.entity.Orden;

public interface IOrdenService {
 
		public boolean guardar(Orden pojo);
		public boolean actualizar(Orden pojo);
		public boolean eliminar(Orden pojo);
		public Orden getOrden(int idOrden);
}
