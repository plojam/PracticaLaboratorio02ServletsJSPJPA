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
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class BuscarUsuario
 */
@WebServlet("/BuscarUsuarioAdmin")
public class BuscarUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDao;
    private EmpresaDAO empresaDao;
    private Usuario usuario;
    private Empresa empresa;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarioAdmin() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	empresaDao = DAOFactory.getFactory().getEmpresaDAO();
    	usuario = new Usuario();
    	empresa = new Empresa();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			int usuario_id = Integer.valueOf(request.getParameter("usu_id"));
			int empresa_id = Integer.valueOf(request.getParameter("emp_id"));
			
			empresa = empresaDao.read(empresa_id);
			usuario = usuarioDao.read(usuario_id);
			request.setAttribute("usuario", usuario);
			request.setAttribute("empresa", empresa);
			
			url = "/JSPs/perfilAdmin.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}

