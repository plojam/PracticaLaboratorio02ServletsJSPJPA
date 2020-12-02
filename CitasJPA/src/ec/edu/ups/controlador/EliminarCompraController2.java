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

/**
 * Servlet implementation class EliminarCompraController2
 */
@WebServlet("/EliminarCompraController2")
public class EliminarCompraController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CabeceraDAO cabeceraDao;
	private Cabecera cabecera;
	private List<Cabecera> listaCabecera; 
	
    public EliminarCompraController2() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	cabecera = new Cabecera();
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int cab_id = Integer.valueOf(request.getParameter("item"));
		
		String estado = "D";
		cabecera.setEstado(estado);
		cabecera.setId(cab_id);
		
		cabeceraDao.update(cabecera);
		
		listaCabecera = cabeceraDao.listarPorUsuario(usuario_id);
		
		request.setAttribute("listaCabecera", listaCabecera);
		request.setAttribute("usuario_id", usuario_id);
		
		
		getServletContext().getRequestDispatcher("/JSPs/eliminar_Compra.jsp").forward(request, response);
	}

}
