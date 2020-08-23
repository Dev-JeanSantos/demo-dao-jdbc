package modelo.dao;

import modelo.dao.impl.VendedorDaoJDBC;

public class DaoFabrica {
	
	public static VendedorDao inserirVendedorDao() {
		return new VendedorDaoJDBC();
	}
}
