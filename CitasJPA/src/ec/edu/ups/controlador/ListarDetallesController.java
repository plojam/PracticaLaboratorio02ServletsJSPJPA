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
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class ListarDetallesController
 */
@WebServlet("/ListarDetallesController")
public class ListarDetallesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetalleDAO detalleDao;
	private CabeceraDAO cabeceraDao;
	private UsuarioDAO usuarioDao;
	private List<Detalle> detalles;
	private List<Cabecera> cabeceras;
	private List<Usuario> usuarios;
	
	private int usuario_id;
	private int usuarioS_id;
	private int empresa_id;
	private int cabecera_id;
	private String comprobar;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarDetallesController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			comprobar = "t";
			
			usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			usuarioS_id = Integer.valueOf(request.getParameter("usuarioS_id"));
			empresa_id = Integer.valueOf(request.getParameter("empresa_id"));
			cabecera_id = Integer.valueOf(request.getParameter("cab_id"));
			
			cabeceras = cabeceraDao.listarPorUsuario(usuarioS_id);
			detalles = detalleDao.buscarPorCabecera(cabecera_id);
			usuarios = usuarioDao.buscarSoloUsuario(empresa_id);
			
			request.setAttribute("detalles", detalles);
			request.setAttribute("cabeceras", cabeceras);
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("usuario_id", usuario_id);
			request.setAttribute("usuarioS_id", usuarioS_id);
			request.setAttribute("empresa_id", empresa_id);
			request.setAttribute("comprobar", comprobar);
			
			url = "/JSPs/administrar_pedidos.jsp";
		} catch(Exception e) {
			System.out.println("Error Pedidos Det.: " + e);
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
