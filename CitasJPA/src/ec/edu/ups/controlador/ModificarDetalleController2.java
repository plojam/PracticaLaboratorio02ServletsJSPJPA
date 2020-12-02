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
 * Servlet implementation class ModificarDetalleController2
 */
@WebServlet("/ModificarDetalleController2")
public class ModificarDetalleController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DetalleDAO detalleDao;
	private List<Detalle> listaDetalle; 
	
	private ProductoDAO productoDao;
    private List<Producto> listaProductos;
    
    private Producto producto;
    private Detalle detalle;
	
	
	
	
    public ModificarDetalleController2() {
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    	detalle = new Detalle();
    	
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		
		int det_id = Integer.valueOf(request.getParameter("det_id"));
		int cab_id2 = Integer.valueOf(request.getParameter("cab_id"));
		
			
		String cP = request.getParameter("cantidadP");
		
		
		System.out.println("VER ID USUARIO +++++++ : " + usuario_id);
		System.out.println("VER ID Cab enviada +++++++ : " + cab_id2);
		
		if (cP.equals("")) {
			
		}else {
			int cPP = Integer.parseInt(cP);
			
			detalle.setCantidad(cPP);
			detalle.setId(det_id);
			detalleDao.update(detalle);
		}
		
		listaDetalle = detalleDao.buscarPorCabecera(cab_id2);
		System.out.println("Tamaño de la lista recuperada C +++++++ : " + listaDetalle.size());
		request.setAttribute("listaDetalle", listaDetalle);
		request.setAttribute("usuario_id", usuario_id);
		request.setAttribute("cabecera_id", cab_id2);
		
		getServletContext().getRequestDispatcher("/JSPs/modificar_Detalle.jsp").forward(request, response);
	} 

}
