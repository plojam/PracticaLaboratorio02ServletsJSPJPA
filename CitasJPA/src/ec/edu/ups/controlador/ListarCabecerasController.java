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
 * Servlet implementation class ListarCabecerasController
 */
@WebServlet("/ListarCabecerasController")
public class ListarCabecerasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CabeceraDAO cabeceraDao;
	private UsuarioDAO usuarioDao;
	private List<Cabecera> cabeceras;
	private List<Usuario> usuarios;
	
	private int usuario_id;
	private int usuarioS_id;
	private int empresa_id;
	private String pagina;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCabecerasController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO(); 
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
			usuarios = usuarioDao.buscarSoloUsuario(empresa_id);
			
			pagina = String.valueOf(request.getParameter("page"));
			
			if(pagina.equals("cp")) {
				cabeceras = cabeceraDao.listarPorUsuario(usuarioS_id);
				
				request.setAttribute("usuarios", usuarios);
				request.setAttribute("usuario_id", usuario_id);
				request.setAttribute("usuarioS_id", usuarioS_id);
				request.setAttribute("empresa_id", empresa_id);
				request.setAttribute("cabeceras", cabeceras);
				
				url = "/JSPs/administrar_pedidos.jsp";
				
			} else if(pagina.equals("lp")) {
				cabeceras = cabeceraDao.listarRevisadas(usuarioS_id);
				
				request.setAttribute("usuarios", usuarios);
				request.setAttribute("usuario_id", usuario_id);
				request.setAttribute("usuarioS_id", usuarioS_id);
				request.setAttribute("empresa_id", empresa_id);
				request.setAttribute("cabeceras", cabeceras);
				
				url = "/JSPs/listar_pedidos.jsp";
			}
			
		} catch(Exception e) {
			System.out.println("Error Pedidos Cab.: " + e);
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
