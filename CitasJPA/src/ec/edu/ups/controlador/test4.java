package ec.edu.ups.controlador;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

public class test4 {

	public static void main(String[] args) {
UsuarioDAO usudao = DAOFactory.getFactory().getUsuarioDAO();
		
		ProductoDAO prodao = DAOFactory.getFactory().getProductoDAO();
		
		Producto pro = prodao.read(1);
		Producto pro2 = prodao.read(2);
		
		Usuario usu = usudao.login("eloja", "eloja");
		
		Cabecera cab = new Cabecera(0, "e", usu);
		
		Detalle det1 = new Detalle(0, 2, pro, cab);
		
		Detalle det2 = new Detalle(0, 5, pro2, cab);
		
		cab.addDetalles(det1);
		cab.addDetalles(det2);
		
		usu.addCabeceras(cab);
		
		usudao.update(usu);
	}

}
