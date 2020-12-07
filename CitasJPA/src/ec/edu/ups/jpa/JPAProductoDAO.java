package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

public class JPAProductoDAO extends JPAGenericDAO<Producto, Integer> implements ProductoDAO {

	
	public JPAProductoDAO() {
		super(Producto.class);
	}

	public int empresaId(int id) {
		String jpql = "SELECT p.empresa.id FROM Producto p WHERE p.id=" + id;
		int empId = (int) em.createQuery(jpql).getSingleResult();
		return empId;
	}

	public int categoriaId(int id) {
		String jpql = "SELECT p.categoria.id FROM Producto p WHERE p.id=" + id;
		int catId = (int) em.createQuery(jpql).getSingleResult();
		return catId;
	}

	public List<Producto> findEmpresa(int empId) {
		String jpql = "SELECT p FROM Producto p WHERE p.empresa.id="+empId + " AND p.estado != 'e'";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public List<Producto> buscarPorCateoria(int catId, int empId) {
		String jpql = "SELECT p FROM Producto p WHERE p.empresa.id=" + empId + " AND p.categoria.id=" + catId + " AND p.estado !='e'";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public Producto buscarPorNombre(String nombre, int empId) {
		String jpql = "SELECT p FROM Producto p WHERE p.nombre='" + nombre + "' AND p.empresa.id=" + empId;
		Producto producto = (Producto) em.createQuery(jpql).getSingleResult();
		return producto;
	}
	
	
	
	
	
	
	
	
	public List<Producto> buscarPorCateoria2(int catId) {
		
		String jpql = "SELECT p FROM Producto p WHERE p.categoria.id=" + catId + " AND p.estado != 'e'";
		List<Producto> list = em.createQuery(jpql).getResultList();
		return list;
	}
	
	
	
	
	
	
	
	public Producto buscarSoloPorNombre(String nombre) {
		String jpql = "SELECT p FROM Producto p WHERE p.nombre='" + nombre + "'";
		Producto producto = (Producto) em.createQuery(jpql).getSingleResult();
		return producto;
	}
	
	
	
	
	
	
	public Producto TEST (int id_pro) {
		String jpql = "SELECT p FROM Producto p WHERE p.id=" + id_pro ;
		Producto producto = (Producto) em.createQuery(jpql).getSingleResult();
		return producto;
	}
	
	
	
	
	
	
	
	public int obtenerCategoriaId(int producto) {
		String jpql = "SELECT p.categoria.id FROM Producto p WHERE p.id = " + producto;
		int cat_id = (int) em.createQuery(jpql).getSingleResult();
		return cat_id;
	}
	
	

}
