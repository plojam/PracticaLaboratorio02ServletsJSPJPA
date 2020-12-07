package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.modelo.Detalle;

public interface DetalleDAO extends GenericDAO<Detalle, Integer> {
	
	public abstract List<Detalle> buscarPorCabecera(int cabeceraId);
	
	
	public Detalle test2(int pro_id, int cab_id);
	
	public int obtenerProductoId(Detalle detalle);
	
	public void crear(Detalle detalle, int cabeceraId, int productoId);
}
