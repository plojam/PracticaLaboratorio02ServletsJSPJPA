package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * Servlet implementation class ListarCompraController
 */
@WebServlet("/ListarCompraController")
public class ListarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CabeceraDAO cabeceraDao;
	private DetalleDAO detalleDao;
	private List<Cabecera> listaCabeceraSinDelete;
	private List<Detalle> listaDetalle; 
	private Detalle detalle;
	private Cabecera cabecera;
	
	
    public ListarCompraController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	detalle = new Detalle();
    	cabecera = new Cabecera();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		listaCabeceraSinDelete = cabeceraDao.listarSinDelete(usuario_id);
		List<Cabecera> listaCabeceraSinDelete2 = new ArrayList<Cabecera>();
		
		for (int i = 0; i<listaCabeceraSinDelete.size(); i++ ) {
			cabecera = listaCabeceraSinDelete.get(i);
			if(cabecera.getEstado().equals("e")){
				System.out.println("entra 1");
				cabecera.setEstado("Espera");
				
			}else if (cabecera.getEstado().equals("A")) {
				System.out.println("entra 2");
				cabecera.setEstado("Aceptado");
				
			}else if( cabecera.getEstado().equals("R")){
				System.out.println("entra 3");
				cabecera.setEstado("Rechazado");
			}
			listaCabeceraSinDelete2.add(new Cabecera ( cabecera.getId(), cabecera.getEstado(), cabecera.getUsuario()));
			
		}
		request.setAttribute("listaCabeceraSinDelete2", listaCabeceraSinDelete2);
		request.setAttribute("usuario_id", usuario_id);
		
		
		this.getServletContext().getRequestDispatcher("/JSPs/listar_compra.jsp").forward(request, response);
	}

}
