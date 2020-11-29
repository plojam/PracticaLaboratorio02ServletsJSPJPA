package ec.edu.ups.controlador;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

public class test3 {

	public static void main(String[] args) {
		CategoriaDAO catdao = DAOFactory.getFactory().getCategoriaDAO();
		Categoria cat = new Categoria(0, "maquillaje");
		catdao.create(cat);
		
		Categoria cat2 = new Categoria(0, "moda");
		catdao.create(cat2);
		
		
		cat = catdao.read(2);
		cat2 = catdao.read(3);
		
		EmpresaDAO empdao = DAOFactory.getFactory().getEmpresaDAO();
		
		Empresa emp = empdao.read(1);
		
		emp.addUsuarios(new Usuario(0, "esteban", "morocho", "eloja", "eloja", "u", emp));
		
		emp.addProductos(new Producto(0, "cascada pro", 50, "h", cat2, emp));
		
		empdao.update(emp);
	}

}
