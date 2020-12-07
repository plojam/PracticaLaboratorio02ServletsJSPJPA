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
 * Servlet implementation class ListarCompraController2
 */
@WebServlet("/ListarCompraController2")
public class ListarCompraController2 extends HttpServlet {
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
	
    public ListarCompraController2() {
    	
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
    	producto = new Producto();
    	detalle = new Detalle();
    	categoria = new Categoria();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int Cab = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("llega user +++++++ "  + usuario_id);
		System.out.println("llega cabecera id +++++++ "  + Cab);
		
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
		
		
		
		getServletContext().getRequestDispatcher("/JSPs/listar_Compra_Detalle.jsp").forward(request, response);
	}
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		/*
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int Cab = Integer.valueOf(request.getParameter("item"));
		
		
		listaDetalle = detalleDao.buscarPorCabecera(Cab);
		List<Detalle> listaDetalle2 = new ArrayList<Detalle>();
		
		for (int i = 0; i<listaDetalle.size(); i++ ) {
			detalle = listaDetalle.get(i);
			System.out.println("ID FUNCIONAA ----  :  " + detalle.getId());
			
			int id_pro = detalleDao.obtenerProductoId(detalle);
			
			producto = productoDao.TEST(id_pro);
			
			detalle.setProducto(producto);
			
			//det2.setId(detalle.getId());
			//det2.setCantidad(detalle.getCantidad());
			//det2.setProducto(producto);
			System.out.println("ID ///   " + detalle.getId());
			System.out.println("CANTIDAD ///   " + detalle.getCantidad());
			System.out.println("NOMBRE ///   " + detalle.getProducto().getNombre() );
			
			
			listaDetalle2.add(new Detalle (detalle.getId(), detalle.getCantidad(), detalle.getProducto()));
			
		}
		
		System.out.println("Tamaño LISTA 1  +++++++ :    " + listaDetalle.size());
		System.out.println("Tamaño LISTA 2  +++++++ :    " + listaDetalle2.size());
		
		
		
		//System.out.println("Tamaño de la lista recuperada C +++++++ : " + listaDetalle.size());
		request.setAttribute("listaDetalle2", listaDetalle2);
		//request.setAttribute("usuario_id", usuario_id);
		//request.setAttribute("cabecera_id", Cab);
		*/
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
