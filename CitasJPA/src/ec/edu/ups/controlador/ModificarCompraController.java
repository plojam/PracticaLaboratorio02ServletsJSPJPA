package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ModificarCompraController
 */
@WebServlet("/ModificarCompraController")
public class ModificarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CabeceraDAO cabeceraDao;
	private List<Cabecera> listaCabecera; 
	
    public ModificarCompraController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		
		System.out.println("VER ID USUARIO CORRECTO ------- : " + usuario_id);
		listaCabecera = cabeceraDao.listarPorUsuario(usuario_id);
		System.out.println("Tamaño de la lista recuperada C ------- : " + listaCabecera.size());
		request.setAttribute("listaCabecera", listaCabecera);
		request.setAttribute("usuario_id", usuario_id);
		
		getServletContext().getRequestDispatcher("/JSPs/modificar_Compra.jsp").forward(request, response);
	}

}
