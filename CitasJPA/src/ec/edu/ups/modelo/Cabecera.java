package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cabecera
 *
 */
@Entity
@Table(name="pedcabecera")
public class Cabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String estado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cabecera")
	private ArrayList<Detalle> detalles;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	public Cabecera(int id, String estado, ArrayList<Detalle> detalles, Usuario usuario) {
		super();
		this.id = id;
		this.estado = estado;
		this.detalles = detalles;
		this.usuario = usuario;
	}
	
	public Cabecera() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
   
}
