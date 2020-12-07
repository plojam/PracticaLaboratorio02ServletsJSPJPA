package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class EliminarProductoController
 */
@WebServlet("/EliminarProductoController")
public class EliminarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductoDAO productoDao;
    private Producto producto;
    private List<Producto> productos;
     
    private int producto_id;
    private int usuario_id;
    private int empresa_id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			usuario_id = Integer.valueOf(request.getParameter("usu_id"));
			empresa_id = Integer.valueOf(request.getParameter("emp_id"));
			producto_id = Integer.valueOf(request.getParameter("pro_id"));
			
			producto = productoDao.read(producto_id);
			producto.setEstado("e");
			productoDao.update(producto);
			productos = productoDao.findEmpresa(empresa_id);
			
			request.setAttribute("productos", productos);
			request.setAttribute("empresa_id", empresa_id);
			request.setAttribute("usuario_id", usuario_id);

			url = "/JSPs/modificar_producto.jsp";
		} catch (Exception e) {
			System.out.println("Error Eliminar: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
