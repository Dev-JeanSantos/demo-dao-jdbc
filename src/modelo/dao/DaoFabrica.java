package modelo.dao;

import db.DB;
import modelo.dao.impl.VendedorDaoJDBC;

public class DaoFabrica {
	
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());//Se faz necessário pasar o metodo para iniciar uma conexao
	}
	
	
}
