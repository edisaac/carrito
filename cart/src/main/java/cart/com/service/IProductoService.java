package cart.com.service;

import java.util.List;

import cart.com.entity.Producto;

public interface IProductoService {
	public boolean guardar(Producto pojo);
	public boolean actualizar(Producto pojo);
	public boolean eliminar(Producto pojo);
	public Producto getProducto(int idProducto);
	public List<Producto> getProductos();
	public List<Producto> getProductosByEstablecimiento(int idEstablecimiento);
}

