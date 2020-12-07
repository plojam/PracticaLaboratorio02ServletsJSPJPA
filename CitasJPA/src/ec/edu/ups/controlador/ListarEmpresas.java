package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ListarEmpresas
 */
@WebServlet("/ListarEmpresas")
public class ListarEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpresaDAO empresaDao;
    
    private List<Empresa> empresas;
    private List<Producto> productos_emp1;
    private List<Producto> productos_emp2;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarEmpresas() {
    	empresaDao = DAOFactory.getFactory().getEmpresaDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = null;
		
		try{
			empresas = empresaDao.find();
			
			productos_emp1 = empresas.get(0).getProductos();
			productos_emp2 = empresas.get(1).getProductos();
			
			request.setAttribute("empresas", empresas);
			request.setAttribute("productos_emp1", productos_emp1);
			request.setAttribute("productos_emp2", productos_emp2);
			
			url = "/JSPs/listar_empresas.jsp";
		} catch(Exception e) {
			System.out.println("ERROR Listar Emp: " + e);
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
    }
	
}
