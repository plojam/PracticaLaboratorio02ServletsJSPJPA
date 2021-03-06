package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ec.edu.ups.modelo.Cabecera;

public interface CabeceraDAO extends GenericDAO<Cabecera, Integer> {
	
	public abstract List<Cabecera> listarPorUsuario(int usuarioId);
	public int ultimoCreado();
	public List<Cabecera> listarRevisadas(int usuarioId);
	
	public Cabecera buscarCabecera (int id);
	
	public List<Cabecera> listarSinDelete(int usuarioId);
	
}
