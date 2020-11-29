package ec.edu.ups.controlador;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

public class test2 {

	public static void main(String[] args) {
CategoriaDAO catdao = DAOFactory.getFactory().getCategoriaDAO();
		 
		
		Empresa emp = new Empresa(0, "avon");
		
		Categoria cat = catdao.read(1);
		
		Usuario usu = new Usuario(0, "pablo", "loja", "ploja", "ploja", "a", emp);
		
		Producto pro = new Producto(0, "pantalones v2", 20, "h", cat, emp);
		
		emp.addUsuarios(usu);
		emp.addProductos(pro);
		
		cat.addProductos(pro);
		//por la conexion bilateral que se tiene, no es neccesario crear la primera empresa, al actualizar el catalogo se hace automaticamente
		//IMPORTANTE: Si se manda a crear la empresa y a actualizar el catalogo, se crearia 2 veces la empresa, ya me paso eso xd
		catdao.update(cat);
	}

}
