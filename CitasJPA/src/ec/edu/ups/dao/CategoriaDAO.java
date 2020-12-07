package ec.edu.ups.dao;

import ec.edu.ups.modelo.Categoria;

public interface CategoriaDAO extends GenericDAO<Categoria, Integer> {

	public Categoria read2(String cat_nom);
}
