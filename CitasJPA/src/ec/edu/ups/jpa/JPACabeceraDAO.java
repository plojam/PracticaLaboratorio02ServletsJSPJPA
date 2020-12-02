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
		List<Cabecera> cabeceras = (List<Cabecera>) em.createQuery(jpql).getResultList();
		return cabeceras;

	}


	public int ultimoCreado() {
		String jpql = "SELECT max(c.id) FROM Cabecera c";
		int catId = (int) em.createQuery(jpql).getSingleResult();
		return catId;
	}


	public List<Cabecera> listarRevisadas(int usuarioId) {
		String jpql = "SELECT c FROM Cabecera c WHERE c.usuario.id="+usuarioId+ " AND c.estado!='e'";
		List<Cabecera> cabeceras = (List<Cabecera>) em.createQuery(jpql).getResultList();
		return cabeceras;
	}

	
	
	
}
