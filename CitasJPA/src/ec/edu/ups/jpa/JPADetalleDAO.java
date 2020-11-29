package ec.edu.ups.jpa;

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

	
	
	
}
