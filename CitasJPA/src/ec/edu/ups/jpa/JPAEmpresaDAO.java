package ec.edu.ups.jpa;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Empresa;

public class JPAEmpresaDAO extends JPAGenericDAO<Empresa, Integer> implements EmpresaDAO {

	public JPAEmpresaDAO() {
		super(Empresa.class);
	}

}
