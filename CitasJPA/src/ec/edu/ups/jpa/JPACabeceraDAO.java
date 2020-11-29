package ec.edu.ups.jpa;

import java.util.List;
import java.util.Locale.Category;

import com.mysql.cj.Query;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.modelo.Cabecera;

public class JPACabeceraDAO extends JPAGenericDAO<Cabecera, Integer> implements CabeceraDAO {

	public JPACabeceraDAO() {
		super(Cabecera.class); 
	}


	public List<Cabecera> listarPorUsuario(int usuarioId) {
		String jpql = "SELECT c FROM Cabecera c WHERE c.usuario.id="+usuarioId;
		List<Cabecera> cabeceras = em.createQuery(jpql).getResultList();
		return cabeceras;

	}

	
	
	
}
