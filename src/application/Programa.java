package application;

import modelo.dao.DaoFabrica;
import modelo.dao.VendedorDao;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
				
		System.out.println("=== TESTE BUSCA VENDEDOR POR ID ===");
		VendedorDao vendedorDao = DaoFabrica.criarVendedorDao();
		Vendedor vendedor = vendedorDao.pesquisarPorId(1);		
		System.out.println(vendedor);
	}

}
