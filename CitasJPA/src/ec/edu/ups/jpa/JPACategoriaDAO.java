package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO {

	public JPACategoriaDAO() {
		super(Categoria.class);
	}
	
	
	public Categoria read2(String cat_nom) {
		String jpql = "SELECT c FROM Categoria c WHERE c.nombre= '" + cat_nom + "'";
		Categoria categoria = (Categoria) em.createQuery(jpql).getSingleResult(); 

		return categoria;
	}

}
