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
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Cabecera;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class TEST
 */
@WebServlet("/TEST")
public class TEST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO usudao;
	private ProductoDAO productoDao;
    private List<Producto> listaProductos;
    private List<Categoria> listaCategoria;
    private CategoriaDAO categoriaDao;
    private Producto producto;
    private DetalleDAO detalleDao;
    private Detalle detalle;
    private CabeceraDAO cabeceraDao;
    private Cabecera cabecera;
    private Categoria categoria;
    
    
    int cont=0;
    int cont2=0;
    
    public TEST() {
    	
    	UsuarioDAO usudao = DAOFactory.getFactory().getUsuarioDAO();
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	detalle = new Detalle();
    	
    	producto = new Producto();
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
    	cabecera = new Cabecera();
    
    	categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
    	categoria = new Categoria();
    }
    
    
    
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		int cabecera_id = Integer.valueOf(request.getParameter("ver_id"));
		
		
		String p = request.getParameter("item");
		String c = request.getParameter("cantidad");
		
		String cat_nombre = request.getParameter("item2");
		
		System.out.println("OBTENGO CABECERA   :   " + cabecera_id);
		System.out.println("OBTENGO USUARIO_ID   :   " + usuario_id);
		System.out.println("OBTENGO cantidad   :   " + c);
		System.out.println("OBTENGO nombre producto   :   " + p);
		System.out.println("OBTENGO nombre categoria   :   " + cat_nombre);
		
		
		System.out.println("TEXTO   :   " + p);
		int ultimo_id = cabeceraDao.ultimoCreado();
		
		if (c == null && cat_nombre.equals("- Seleccione categoria -") ) {
			System.out.println("entro bien al primer if");
			
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
			
			
			request.setAttribute("listaProductos2", listaProductos2);
			
			
			
		}else if(c == null) {
			System.out.println("ENTRA EN EL ELSE IF");
			categoria = categoriaDao.read2(cat_nombre);
			listaProductos = productoDao.buscarPorCateoria2(categoria.getId());
			
			
			List<Producto> listaProductos2 = new ArrayList<Producto>();
			
			for (int i = 0; i<listaProductos.size(); i++ ) {
				producto = listaProductos.get(i);
				int id_cat = productoDao.categoriaId(producto.getId());
				categoria = categoriaDao.read(id_cat);
				producto.setCategoria(categoria);
				
				listaProductos2.add(new Producto (producto.getId(), producto.getNombre() , producto.getCantidad(), producto.getEstado(),
						producto.getCategoria(), producto.getEmpresa()));	
			}
			
			request.setAttribute("listaProductos2", listaProductos2);
			
		}else {
		
		if (c.equals("") ) {
			System.out.println("---------------------------");
			System.out.println("VALOR DE CANTIDAD :  " + c);
			System.out.println("---------------------------");
			
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
			
			
			request.setAttribute("listaProductos2", listaProductos2);
			
			
			
		}else {
			int cc = Integer.parseInt(c);
			cont=cont+1;
			
				listaProductos = productoDao.find();
				
				System.out.println("Tamaño de la lista recuperada: " + listaProductos.size());
				System.out.println("VER posicion del  PRODUCTO: " + p);
				System.out.println("VER cantidad de Producto: " + c);
				
				producto = productoDao.buscarSoloPorNombre(p);
				System.out.println("ID DEL PRODUCTOOOO : " + producto.getId());
				
				detalle.setCantidad(cc);
				int ver = detalle.getId();
				int ver2 = detalle.getCantidad();
				
				System.out.println("ver    " + ver);
				System.out.println("ver 2  " + ver2);
				
				detalleDao.crear(detalle, cabecera_id, producto.getId());
				
				
				
				
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
				
				
				request.setAttribute("listaProductos2", listaProductos2);
				request.setAttribute("number1", Integer.toString(cont));
				
				
		}
		}
		
		listaCategoria = categoriaDao.find();
		request.setAttribute("listaCategoria", listaCategoria);
		
		request.setAttribute("usuario_id", usuario_id);
		request.setAttribute("cabecera_id", ultimo_id);
		
		this.getServletContext().getRequestDispatcher("/JSPs/registrar_Compra.jsp").forward(request, response);
		
	}

}
