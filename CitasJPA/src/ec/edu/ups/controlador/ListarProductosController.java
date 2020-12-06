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
 * Servlet implementation class ListarProductosController
 */
@WebServlet("/ListarProductosController")
public class ListarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
    private List<Producto> listaProductos;
    
    private int usuario_id;
    private int empresa_id;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	listaProductos = null;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		System.out.println("Entra al Listado");
		try {
			String page = request.getParameter("page");
			
			usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			empresa_id = Integer.valueOf(request.getParameter("empresa_id")); 

			if(page.equals("m")) {
				
				listaProductos = productoDao.findEmpresa(empresa_id);
				
				request.setAttribute("productos", listaProductos);
				request.setAttribute("empresa_id", empresa_id);
				request.setAttribute("usuario_id", usuario_id);
				
				//System.out.println("PRODUCTO ID: " + producto.getId());
				//System.out.println("EMPRESA ID: " + producto.getEmpresa().getId());
				
				System.out.println("Cantidad 1 ID: " + listaProductos.get(0).getCantidad());
				System.out.println("Cantidad 2 ID: " + listaProductos.get(1).getCantidad());
				System.out.println("Cantidad 3 ID: " + listaProductos.get(2).getCantidad());
				System.out.println("Cantidad 4 ID: " + listaProductos.get(3).getCantidad());
				
				url = "/JSPs/modificar_producto.jsp";
			}
		} catch (Exception e) {
			System.out.println("Error Listar: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
