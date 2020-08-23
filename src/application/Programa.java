package application;

import modelo.dao.DaoFabrica;
import modelo.dao.VendedorDao;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
				
		VendedorDao vendedorDao = DaoFabrica.criarVendedorDao();
		
		Vendedor vendedor = vendedorDao.pesquisarPorId(3);
		
		System.out.println(vendedor);
	}

}
