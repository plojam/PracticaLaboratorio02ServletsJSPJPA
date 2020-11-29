package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private String usuario;
	@Column(nullable=false)
	private String contrasena;
	@Column(nullable=false)
	private String rol;
	@Column(nullable=false)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private ArrayList<Cabecera> cabeceras;
	@ManyToOne
	@JoinColumn
	private Empresa empresa;
	
	public Usuario(int id, String nombre, String apellido, String usuario, String contrasena, String rol, ArrayList<Cabecera> cabeceras, Empresa empresa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.rol = rol;
		this.cabeceras = cabeceras;
		this.empresa = empresa;
	}
	
	public Usuario() {
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public ArrayList<Cabecera> getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(ArrayList<Cabecera> cabeceras) {
		this.cabeceras = cabeceras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
   
}
