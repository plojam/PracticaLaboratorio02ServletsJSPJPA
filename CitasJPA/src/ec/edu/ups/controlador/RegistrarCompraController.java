package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class RegistrarCompraController
 */
@WebServlet("/RegistrarCompraController")
public class RegistrarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoDAO productoDao;
    private List<Producto> listaProductos; 
    
    private CabeceraDAO cabeceraDao;
    private Cabecera cabecera;
    int cont=0;
    
    public RegistrarCompraController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	cabecera = new Cabecera();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		
		System.out.println("ver id de user:  " + usuario_id);
		
		
		int ultimo_id = cabeceraDao.ultimoCreado();
		
		System.out.println("ULTIMO CREADO : " + ultimo_id);
		
		
		if (ultimo_id == 0) {
			System.out.println("VERIFICAR EL IF ");
		}else {
		cont=ultimo_id+1;
		cabecera.setId(cont);
		cabecera.setEstado("e");
		//cabeceraDao.crear(cabecera, usuario_id);
		//MACAO DEBES REVISAR ESTE METODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		System.out.println("CABECERA CREADA ");
		System.out.println("id cab : " + cabecera.getId());
		
			
		}
		
		try {
			
			listaProductos = productoDao.find();
			System.out.println("Tamaño de la lista recuperada: " + listaProductos.size());
			
			request.setAttribute("listaProductos", listaProductos);
			request.setAttribute("usuario_id", usuario_id);
			request.setAttribute("cabecera_id", cabecera.getId());
			System.out.println("FINALIZA PRIMER SERBVLET");
			url = "/JSPs/registrar_Compra.jsp";
			
			
		} catch (Exception e) {
			System.out.println("Error Listar: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);	
		
	}

}



