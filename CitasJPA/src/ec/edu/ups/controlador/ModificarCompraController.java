package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ModificarCompraController
 */
@WebServlet("/ModificarCompraController")
public class ModificarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CabeceraDAO cabeceraDao;
	private List<Cabecera> listaCabecera; 
	private Cabecera cabecera;
	
    public ModificarCompraController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	cabecera = new Cabecera();
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		
		listaCabecera = cabeceraDao.listarPorUsuario(usuario_id);
		
		List<Cabecera> listaCabecera2 = new ArrayList<Cabecera>();
		
		for (int i = 0; i<listaCabecera.size(); i++ ) {
			cabecera = listaCabecera.get(i);
			if(cabecera.getEstado().equals("e")){
				cabecera.setEstado("Espera");
				
			}else if (cabecera.getEstado().equals("A")) {
				cabecera.setEstado("Aceptado");
				
			}else if( cabecera.getEstado().equals("R")){
				cabecera.setEstado("Rechazado");
			}
			
			listaCabecera2.add(new Cabecera (cabecera.getId(), cabecera.getEstado(), cabecera.getUsuario()));
			
			System.out.println("ID FUNCIONAA ----  :  " + cabecera.getId());
			
		}
		
		
		//listaCabecera = cabeceraDao.listarPorUsuario(usuario_id);
		request.setAttribute("listaCabecera", listaCabecera2);
		request.setAttribute("usuario_id", usuario_id);
		
		getServletContext().getRequestDispatcher("/JSPs/modificar_Compra.jsp").forward(request, response);
		
		
	}
	
    
/*
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		
		System.out.println("VER ID USUARIO CORRECTO ------- : " + usuario_id);
		listaCabecera = cabeceraDao.listarPorUsuario(usuario_id);
		System.out.println("Tamaño de la lista recuperada C ------- : " + listaCabecera.size());
		request.setAttribute("listaCabecera", listaCabecera);
		request.setAttribute("usuario_id", usuario_id);
		
		getServletContext().getRequestDispatcher("/JSPs/modificar_Compra.jsp").forward(request, response);
	}
*/

}