package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.modelo.Detalle;

public class JPADetalleDAO extends JPAGenericDAO<Detalle, Integer> implements DetalleDAO {

	public JPADetalleDAO() {
		super(Detalle.class);
		// TODO Auto-generated constructor stub
	}


	public List<Detalle> buscarPorCabecera(int cabeceraId) {
		String jpql = "SELECT d FROM Detalle d WHERE d.cabecera.id="+cabeceraId;
		List<Detalle> detalles = em.createQuery(jpql).getResultList();
		return detalles;
	}
	
	
	
	
	
	
	
	
	
	public int obtenerProductoId(Detalle detalle) {
		String jpql = "SELECT d.producto.id FROM Detalle d WHERE d.id=" + detalle.getId();
		int productoId = (int) em.createQuery(jpql).getSingleResult();
		return productoId;
	}


	
	
}
