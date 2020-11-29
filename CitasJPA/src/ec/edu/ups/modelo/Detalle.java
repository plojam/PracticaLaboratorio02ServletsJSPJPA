package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Detalle
 *
 */
@Entity
@Table(name="peddetalle")
public class Detalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private int cantidad;
	@ManyToOne
	@JoinColumn
	private Producto producto;
	@ManyToOne
	@JoinColumn
	private Cabecera cabecera;
	
	public Detalle(int id, int cantidad, Producto producto, Cabecera cabecera) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.cabecera = cabecera;
	}
	
	public Detalle() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}
	
	
   
}
