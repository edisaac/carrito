package cart.com.service;

import java.util.List;

import cart.com.entity.Establecimiento;
import cart.com.entity.Producto;

public interface IEstablecimientoService {
	public boolean guardar(Establecimiento pojo);
	public boolean actualizar(Establecimiento pojo);
	public boolean eliminar(Establecimiento pojo);
	public Establecimiento getEstablecimiento(int idEstablecimiento);
	public List<Establecimiento> getEstablecimientos();
}
