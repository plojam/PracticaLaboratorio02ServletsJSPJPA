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
    private CategoriaDAO categoriaDao;
    private Categoria categoria;
	
	
	
    public ModificarDetalleController2() {
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    	detalle = new Detalle();
    	categoria = new Categoria();
    	categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
    	
    	
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int Cab = Integer.valueOf(request.getParameter("cab_id"));
		
		String pro_nombre = request.getParameter("item3");
		String cP = request.getParameter("cantidadP");
		
		if (cP.equals("")) {
			
			
			
		}else {
			System.out.println("entra a hacer cambio ");
			
			int cPP = Integer.parseInt(cP);
			
			producto = productoDao.buscarSoloPorNombre(pro_nombre);
			detalle = detalleDao.test2(producto.getId(), Cab);
			System.out.println("id ver : " + detalle.getId());
			detalle.setCantidad(cPP);
			System.out.println("camtidad seteada : " + detalle.getCantidad());
			detalleDao.update(detalle);
		}
		
		
		
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
		
		
		request.setAttribute("listaDetalle", listaDetalle2);
		request.setAttribute("usuario_id", usuario_id);
		request.setAttribute("cabecera_id", Cab);
		
		getServletContext().getRequestDispatcher("/JSPs/modificar_Detalle.jsp").forward(request, response);
	} 

}
