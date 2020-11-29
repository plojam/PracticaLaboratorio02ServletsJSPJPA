package ec.edu.ups.jpa;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	public CabeceraDAO getCabeceraDAO() {
		return new JPACabeceraDAO();
	}

	public CategoriaDAO getCategoriaDAO() {
		return new JPACategoriaDAO();
	}

	public DetalleDAO getDetalleDAO() {
		return new JPADetalleDAO();
	}

	public EmpresaDAO getEmpresaDAO() {
		return new JPAEmpresaDAO();
	}

	public ProductoDAO getProductoDAO() {
		return new JPAProductoDAO();
	}

	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

}
