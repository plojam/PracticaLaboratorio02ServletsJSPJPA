package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private ArrayList<Usuario> usuarios;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private ArrayList<Producto> productos;
	
	public Empresa(int id, String nombre, ArrayList<Usuario> usuarios, ArrayList<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
		this.productos = productos;
	}
	
	public Empresa() {
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

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
   
}
