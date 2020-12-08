package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ListarCompraController3
 */
@WebServlet("/ListarCompraController3")
public class ListarCompraController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetalleDAO detalleDao;
	private List<Detalle> listaDetalle; 
	
	private List<Detalle> listaDetalle2; 
	
	private ProductoDAO productoDao;
    private List<Producto> listaProductos;
    private CategoriaDAO categoriaDao;
    
    private Producto producto;
    private Detalle detalle;
    private Categoria categoria;
    
    public ListarCompraController3() {
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
    	producto = new Producto();
    	detalle = new Detalle();
    	categoria = new Categoria();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int Cab = Integer.valueOf(request.getParameter("id"));
		
		//System.out.println("llega user +++++++ "  + usuario_id);
		//System.out.println("llega cabecera id +++++++ "  + Cab);
		
		listaDetalle = detalleDao.buscarPorCabecera(Cab);
		listaProductos = productoDao.find();
		List<Detalle> listaDetalle2 = new ArrayList<Detalle>();
		
		for (int i = 0; i<listaDetalle.size(); i++ ) {
			detalle = listaDetalle.get(i);
			int producto_id =  detalleDao.obtenerProductoId(detalle);
			int cat_id = productoDao.obtenerCategoriaId(producto_id);
			producto = productoDao.TEST(producto_id);
			categoria = categoriaDao.read(cat_id);
			producto.setCategoria(categoria);
			detalle.setProducto(producto);
			
			listaDetalle2.add(new Detalle (detalle.getId(), detalle.getCantidad() , detalle.getProducto(), detalle.getCabecera()));	
		}
		
		request.setAttribute("listaDetalle2", listaDetalle2);
		request.setAttribute("usuario_id", usuario_id);
		
		getServletContext().getRequestDispatcher("/JSPs/lista_Eliminar_Compra_Detalle.jsp").forward(request, response);
	}

    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
