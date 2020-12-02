package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter({"/Filtro","/JSPs/administrar_pedido.jsp","/JSPs/buscar_producto.jsp","/JSPs/modificar_producto.jsp","/JSPs/registrar_producto.jsp",
			"/JSPs/perfilAdmin.jsp","/JSPs/perfilUser.jsp"})
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		if (session.getAttribute("accesos") == null) {
			((HttpServletResponse) response).sendRedirect("/CitasJPA/HTMLs/login.html");
		}else {
			chain.doFilter(request, response);
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
