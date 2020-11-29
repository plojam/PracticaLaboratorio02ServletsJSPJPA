package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private int cantidad;
	@Column(nullable=false)
	private String estado;
	@Column(nullable=false)
	@ManyToOne
	@JoinColumn
	private Categoria categoria;
	@ManyToOne
	@JoinColumn
	private Empresa empresa;
	
	public Producto(int id, String nombre, int cantidad, String estado, Categoria categoria, Empresa empresa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.estado = estado;
		this.categoria = categoria;
		this.empresa = empresa;
	}
	
	public Producto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
   
}
