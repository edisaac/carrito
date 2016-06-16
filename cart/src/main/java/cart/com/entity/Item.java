package cart.com.entity;

import java.io.Serializable;

public class Item implements Serializable {

	/**
	 * 
	 */
 
	private Producto producto;
	private int cantidad;
	public Item(Producto p, int c){
		super();
		this.producto=p;
		this.cantidad=c;
	}
	public Producto getProducto() {
		return this.producto;
	}
	public void setProducto(Producto product) {
		this.producto = product;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
