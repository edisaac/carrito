package cart.com.dao;

import cart.com.entity.Orden;

public interface IOrdenDao { 
		public void guardar(Orden pojo);
		public void actualizar(Orden pojo);
		public void eliminar(Orden pojo);
		public Orden getOrden(int idOrden);
}
