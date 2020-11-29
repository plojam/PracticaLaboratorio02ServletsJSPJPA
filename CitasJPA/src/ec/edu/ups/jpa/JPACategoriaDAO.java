package ec.edu.ups.jpa;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO {

	public JPACategoriaDAO() {
		super(Categoria.class);
	}

}
