package cart.com.dao;

import java.util.List;
import cart.com.entity.Producto;

public interface IProductoDao {
	public void guardar(Producto pojo);
	public void actualizar(Producto pojo);
	public void eliminar(Producto pojo);
	public Producto getProducto(int idProducto);
	public List<Producto> getProductos();
	public List<Producto> getProductosByEstablecimiento(int idEstablecimiento) ;
}
