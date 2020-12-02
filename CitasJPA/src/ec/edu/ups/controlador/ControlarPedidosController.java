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
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class ControlarPedidosController
 */
@WebServlet("/ControlarPedidosController")
public class ControlarPedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CabeceraDAO cabeceraDao;
	private UsuarioDAO usuarioDao;
	private Cabecera cabecera;
	private List<Cabecera> cabeceras;
	private List<Usuario> usuarios;
       
	private int usuario_id;
	private int usuarioS_id;
	private int empresa_id;
	private int cabecera_id;
	private String estado;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlarPedidosController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	cabecera = new Cabecera();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			usuarioS_id = Integer.valueOf(request.getParameter("usuarioS_id"));
			usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			empresa_id = Integer.valueOf(request.getParameter("empresa_id"));
			cabecera_id = Integer.valueOf(request.getParameter("cab_id"));
			estado = String.valueOf(request.getParameter("estado"));
			
			cabeceras = cabeceraDao.listarPorUsuario(usuarioS_id);
			cabecera = cabeceraDao.read(cabecera_id);
			usuarios = usuarioDao.buscarSoloUsuario(empresa_id);
			
			if (estado.equals("aceptado")) {
				cabecera.setEstado("A");
				cabeceraDao.update(cabecera);
			} else if(estado.equals("negado")) {
				cabecera.setEstado("R");
				cabeceraDao.update(cabecera);
			}
			
			request.setAttribute("cabeceras", cabeceras);
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("usuario_id", usuario_id);
			request.setAttribute("usuarioS_id", usuarioS_id);
			request.setAttribute("empresa_id", empresa_id);
			
			url = "/JSPs/administrar_pedidos.jsp";
		} catch(Exception e) {
			System.out.println("Error Pedidos Cab.: " + e);
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
