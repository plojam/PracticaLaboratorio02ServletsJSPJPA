package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ModificarProductosController
 */
@WebServlet("/ModificarProductosController")
public class ModificarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private CategoriaDAO categoriaDao;
	
	private Producto producto;
	private Categoria categoria;
	private List<Producto> productos;
	
	private int producto_id;
	private int empresa_id;
	private int usuario_id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
        
        producto = new Producto();
        categoria = new Categoria();
        productos = null;
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			usuario_id = Integer.valueOf(request.getParameter("usu_id"));
			empresa_id = Integer.valueOf(request.getParameter("emp_id"));
			producto_id = Integer.valueOf(request.getParameter("producto_id"));
			
			producto = productoDao.read(producto_id);
			categoria = categoriaDao.read(Integer.valueOf(request.getParameter("categoria")));
			
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			producto.setEstado("h");
			//producto.setCategoria(categoria);
			
			productoDao.update(producto);
			
			productos = productoDao.findEmpresa(empresa_id);
			
			System.out.println("PRODUCTO ID: " + producto.getId());
			System.out.println("EMPRESA ID: " + producto.getEmpresa().getId());
			
			System.out.println("Cantidad 1 ID: " + productos.get(0).getCantidad());
			System.out.println("Cantidad 2 ID: " + productos.get(1).getCantidad());
			
			request.setAttribute("productos", productos);
			request.setAttribute("empresa_id", empresa_id);
			request.setAttribute("usuario_id", usuario_id);

			url = "/JSPs/modificar_producto.jsp";
		} catch (Exception e) {
			System.out.println("Error Modificar: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
