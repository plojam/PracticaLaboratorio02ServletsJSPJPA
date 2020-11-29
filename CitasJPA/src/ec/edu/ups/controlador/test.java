package ec.edu.ups.controlador;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Categoria;

public class test {

	public static void main(String[] args) {
		
		CategoriaDAO catdao = DAOFactory.getFactory().getCategoriaDAO();
		Categoria cat = new Categoria(0, "perfume");
		catdao.create(cat);

	}

}
