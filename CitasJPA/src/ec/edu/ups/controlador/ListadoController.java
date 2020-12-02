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
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Detalle;

/**
 * Servlet implementation class ListadoController
 */
@WebServlet("/ListadoController")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CabeceraDAO cabeceraDao;
	private List<Cabecera> listCab;
	
	private DetalleDAO detalleDao;
	private List<Detalle> listDet;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
        detalleDao = DAOFactory.getFactory().getDetalleDAO();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = null;
		
		try {
			
			System.out.println("llega 1 ");
			listCab = cabeceraDao.listarPorUsuario(2);
			System.out.println("Tamaño de la lista recuperada: " + listCab.size());
		
			listDet = detalleDao.buscarPorCabecera(1);
			System.out.println("Tamaño de la lista recuperada: " + listDet.size());
			
			
			request.setAttribute("cab", listCab);
			request.setAttribute("det", listDet);
			
			url = "/JSPs/listar_req.jsp";
			
			System.out.println("envia datos a JSP");
			
			
		} catch (Exception e) {
			System.out.println( " ERROR 0000 " );
		}
		
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
