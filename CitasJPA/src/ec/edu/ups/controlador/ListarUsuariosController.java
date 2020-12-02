package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class ListarUsuariosController
 */
@WebServlet("/ListarUsuariosController")
public class ListarUsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	private List<Usuario> usuarios;
	
	private int empresa_id;
	private int usuario_id;
	private String pagina;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuariosController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			empresa_id = Integer.valueOf(request.getParameter("empresa_id"));
			usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			pagina = String.valueOf(request.getParameter("page"));
			
			usuarios = usuarioDao.buscarSoloUsuario(empresa_id);
			
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("usuario_id", usuario_id);
			request.setAttribute("empresa_id", empresa_id);
			
			if(pagina.equals("cp")) {
				url = "/JSPs/administrar_pedidos.jsp";
				
			} else if(pagina.equals("lp")) {
				url = "/JSPs/listar_pedidos.jsp";
			}
			
		} catch(Exception e) {
			System.out.println("Error Pedidos Cab.: " + e);
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
