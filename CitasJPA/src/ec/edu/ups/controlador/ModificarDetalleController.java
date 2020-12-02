package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ModificarDetalleController
 */
@WebServlet("/ModificarDetalleController")
public class ModificarDetalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DetalleDAO detalleDao;
	private List<Detalle> listaDetalle; 
	
	private ProductoDAO productoDao;
    private List<Producto> listaProductos;
    
    private Producto producto;
    private Detalle detalle;
	
	
    public ModificarDetalleController() {
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    	detalle = new Detalle();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int Cab = Integer.valueOf(request.getParameter("item"));
		
		
		System.out.println("VER ID USUARIO +++++++ : " + usuario_id);
		System.out.println("VER ID Cab enviada +++++++ : " + Cab);
		
		
		listaDetalle = detalleDao.buscarPorCabecera(Cab);
		System.out.println("Tamaño de la lista recuperada C +++++++ : " + listaDetalle.size());
		request.setAttribute("listaDetalle", listaDetalle);
		request.setAttribute("usuario_id", usuario_id);
		request.setAttribute("cabecera_id", Cab);
		
		getServletContext().getRequestDispatcher("/JSPs/modificar_Detalle.jsp").forward(request, response);
	}

}
