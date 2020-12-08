package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class RegistrarCompraController
 */
@WebServlet("/RegistrarCompraController")
public class RegistrarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoDAO productoDao;
	private CategoriaDAO categoriaDao;
    private List<Producto> listaProductos;
    private List<Categoria> listaCategoria;
    private CabeceraDAO cabeceraDao;
    private Cabecera cabecera;
    private Categoria categoria;
    private Producto producto;
    int cont=0;
    
    public RegistrarCompraController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	cabecera = new Cabecera();
    	categoria = new Categoria();
    	producto = new Producto();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int ultimo_id = cabeceraDao.ultimoCreado();
		
		if (ultimo_id == 0) {
			cont=0;
		}else {
			cont=ultimo_id+1;
		}
		System.out.println("count  ** " + cont );
		
		cabecera.setId(cont);
		cabecera.setEstado("e");
		
		//cabeceraDao.crear(cabecera, usuario_id);
		//System.out.println("CABECERA CREADA ");
		//System.out.println("id cab : " + cabecera.getId());
		
		listaCategoria = categoriaDao.find();
		
		
		try {
			listaProductos = productoDao.find();
			List<Producto> listaProductos2 = new ArrayList<Producto>();
			
			for (int i = 0; i<listaProductos.size(); i++ ) {
				producto = listaProductos.get(i);
				int id_cat = productoDao.categoriaId(producto.getId());
				categoria = categoriaDao.read(id_cat);
				producto.setCategoria(categoria);
				listaProductos2.add(new Producto (producto.getId(), producto.getNombre() , producto.getCantidad(), producto.getEstado(),
						producto.getCategoria(), producto.getEmpresa()));	
			}
			
			
			//int count = cabecera.getId() +1;
			request.setAttribute("listaCategoria", listaCategoria);
			request.setAttribute("listaProductos2", listaProductos2);
			request.setAttribute("usuario_id", usuario_id);
			request.setAttribute("cabecera_id", cabecera.getId());
			//System.out.println("FINALIZA PRIMER SERBVLET");
			url = "/JSPs/registrar_Compra.jsp";
			
		} catch (Exception e) {
			System.out.println("Error Listar: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);	
		
	}

}



