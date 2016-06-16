package cart.com.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
import cart.com.entity.*;
import cart.com.service.IEstablecimientoService;
import cart.com.service.IOrdenService;
import cart.com.service.IProductoService; 


@Controller
@Scope(value = "session")
public class CarritoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981069307767978351L;

	private List<Item> carrito=new ArrayList<Item>() ;
    private Producto selectedProducto;
    
	public Producto getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(Producto selectedProducto) {
		agregar (selectedProducto);
		this.selectedProducto = selectedProducto;
	}

	public List<Item> getCarrito() {
		return carrito;
	}

	
	public String agregar(Producto p){
		int indice = existe(p);
		if (indice<0)
			this.carrito.add(new Item(p,1));
		else {
			int cantidad= this.carrito.get(indice).getCantidad();
			this.carrito.get(indice).setCantidad(cantidad+1);
		}
		return "carrito?face-redirect=false";
	}
	
	
	private int existe(Producto p){
		for ( int i=0 ; i< this.carrito.size(); i++){
			if (this.carrito.get(i).getProducto().getIdProducto()==p.getIdProducto())
				return i;
		}
		 return -1;
		}
	
	public BigDecimal getTotal(){
		BigDecimal total;
		BigDecimal subtotal;
		BigDecimal cantidad;
		total = new BigDecimal(0);
		for ( int i=0 ; i< this.carrito.size(); i++){
			cantidad= new BigDecimal(this.carrito.get(i).getCantidad() );
			subtotal=this.carrito.get(i).getProducto().getPrecio().multiply(cantidad );
			total=total.add(	subtotal);				
		}
		return total;
	}
	
	@Autowired
	private IEstablecimientoService  establecimientoService;
	
	private Establecimiento establecimiento;
	
    @RequestMapping(value = "do/{id}.do", method = RequestMethod.GET)
    public String iniciar(@PathVariable("id") int id) {
      this.carrito.clear();
	  establecimiento=establecimientoService.getEstablecimiento(id);
	  return "redirect:../view/productos.xhtml";
    }
    
	public Establecimiento getEstablecimiento() {		 
		return establecimiento;
	}
	
	@Autowired
	private IProductoService productoService;
	
	private List<Producto> productos;
	public List<Producto> getProductos() {
		productos=productoService.getProductosByEstablecimiento(establecimiento.getIdEstablecimiento());
		return productos;
	}
	
	
	@Autowired
	private IOrdenService  ordenService;
	
	private Orden orden;
	
    @RequestMapping(value = "orden/nuevo.do", method = RequestMethod.GET)
    public String nuevaOrden() {
      this.orden=new Orden(); 
      this.orden.setEstablecimiento(establecimiento);
      this.orden.setMonto(getTotal());
	  return "redirect:../view/orden.xhtml";
    }

    public Orden getOrden() {
		return orden;
	}

    public void setOrden(Orden orden) {
		this.orden = orden;
	}
    
    public String grabarOrden(){   	
    	orden.getDetalleOrdens().clear();
    	
    	for (Item item:carrito){
    		 DetalleOrden d = new DetalleOrden();
    		 d.setOrden(this.orden);
    		 d.setCantidad(item.getCantidad());
    		 d.setDescripcion(item.getProducto().getDescripcion());
    		 d.setProducto(item.getProducto());
    		 d.setPrecio(item.getProducto().getPrecio());
    		 orden.getDetalleOrdens().add(d);
    	}
  
    	boolean grabo;
    	grabo=ordenService.guardar(this.orden);  
    	 
    	if (grabo==false){
    	 			return null;
    	}
    	return "detalle.xhtml";
    }
    
}
