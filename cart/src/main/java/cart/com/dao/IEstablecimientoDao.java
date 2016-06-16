package cart.com.dao;

import java.util.List;

import cart.com.entity.Establecimiento;

public interface IEstablecimientoDao {
	public void guardar(Establecimiento pojo);
	public void actualizar(Establecimiento pojo);
	public void eliminar(Establecimiento pojo);
	public Establecimiento getEstablecimiento(int idEstablecimiento);
	public List<Establecimiento> getEstablecimientos();
}
