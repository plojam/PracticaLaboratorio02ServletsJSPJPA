package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract CabeceraDAO getCabeceraDAO();
	
	public abstract CategoriaDAO getCategoriaDAO();
	
	public abstract DetalleDAO getDetalleDAO();
	
	public abstract EmpresaDAO getEmpresaDAO();
	
	public abstract ProductoDAO getProductoDAO();
	
	public abstract UsuarioDAO getUsuarioDAO();
	
}
