package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import com.mysql.cj.Query;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Usuario;

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
		try {
			int catId = (int) em.createQuery(jpql).getSingleResult();
			
			return catId;
		} catch (Exception e) {
			System.out.println("Sin cabecera, manda a crear nueva");
		}
		return 0;
	}


	public List<Cabecera> listarRevisadas(int usuarioId) {
		String jpql = "SELECT c FROM Cabecera c WHERE c.usuario.id="+usuarioId+ " AND c.estado!='e'";
		List<Cabecera> cabeceras = (List<Cabecera>) em.createQuery(jpql).getResultList();
		return cabeceras;
	}
	
	
	public List<Cabecera> listarSinDelete(int usuarioId) {
		String jpql = "SELECT c FROM Cabecera c WHERE c.usuario.id =" + usuarioId + " AND c.estado !='D'";
		List<Cabecera> list = (List<Cabecera>) em.createQuery(jpql).getResultList();
		
		return list;
	}
	
	
	public Cabecera buscarCabecera (int id) {
		String jpql = "SELECT c FROM Cabecera c WHERE c.id= " + id ;
		Cabecera cab = (Cabecera) em.createQuery(jpql).getSingleResult();
		return cab;
	}
	
	
	/*
	 	public Usuario buscarUsuario (int id) {
		String jpql = "SELECT u FROM Usuario u WHERE u.id=" + id ;
		Usuario usu = (Usuario) em.createQuery(jpql).getSingleResult();
		return usu;
	}
	 * */
	 
	
	
	
}
