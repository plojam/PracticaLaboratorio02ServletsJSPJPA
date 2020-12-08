package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	public Usuario login(String usuario, String contrasena) {
		String jpql = "SELECT u FROM Usuario u WHERE u.usuario='" + usuario + "' AND u.contrasena='" + contrasena + "'";
		Usuario usu = (Usuario) em.createQuery(jpql).getSingleResult();
		return usu;
	}

	public List<Usuario> buscarPorEmpresa(int empresaId) {
		String jpql = "SELECT u FROM Usuario u WHERE u.empresa.id=" + empresaId;
		List<Usuario> usuarios = (List<Usuario>) em.createQuery(jpql).getResultList();
		return usuarios;
	}

	public int empresaId(int id) {
		String jpql = "SELECT u.empresa.id FROM Usuario u WHERE u.id=" + id;
		int empId = (int) em.createQuery(jpql).getSingleResult();
		return empId;
	}

	public List<Usuario> buscarSoloUsuario(int empresaId) {
		String jpql = "SELECT u FROM Usuario u WHERE u.rol='u' AND u.empresa.id=" + empresaId;
		List<Usuario> usuarios = em.createQuery(jpql).getResultList();
		return usuarios;
	}
	
	
	public Usuario buscarUsuario (int id) {
		String jpql = "SELECT u FROM Usuario u WHERE u.id=" + id ;
		Usuario usu = (Usuario) em.createQuery(jpql).getSingleResult();
		return usu;
	}

}
