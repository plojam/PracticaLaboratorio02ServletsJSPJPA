package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class BuscarUsuario
 */
@WebServlet("/BuscarUsuario")
public class BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDao;
    private Usuario usuario;
	
	
       
    public BuscarUsuario() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	usuario = new Usuario();
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
			int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			
			usuario = usuarioDao.read(usuario_id);
			
			
			System.out.println("ver usuario regreso*****  : " + usuario.getId());
			
			request.setAttribute("usuario", usuario);
			
			
			url = "/JSPs/perfilUser.jsp";
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
