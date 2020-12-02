package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Producto;

public interface ProductoDAO extends GenericDAO<Producto, Integer> {
	
	public abstract int empresaId(int id);
	public abstract int categoriaId(int id);
	public abstract List<Producto> find(int empId);
	public List<Producto> buscarPorCateoria(int catId, int empId);
	public Producto buscarPorNombre(String nombre, int empId);
	
}