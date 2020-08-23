package application;

import java.util.List;

import modelo.dao.DaoFabrica;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
				
		System.out.println("=== TESTE 1 - BUSCA VENDEDOR POR ID ===");
		VendedorDao vendedorDao = DaoFabrica.criarVendedorDao();
		Vendedor vendedor = vendedorDao.pesquisarPorId(1);		
		System.out.println(vendedor);
		
		System.out.println();
		System.out.println("=== TESTE 2 - BUSCA VENDEDOR POR DEPARTAMENTO ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDao.buscarPorDepartamento(departamento);
		for(Vendedor obj : list) {
			System.out.println(obj);
			
		System.out.println();
		System.out.println("=== TESTE 3 - BUSCA VENDEDOR POR DEPARTAMENTO ===");
		list = vendedorDao.buscarTodos();
		for(Vendedor obj2 : list) {
			System.out.println(obj2);
			}		
		}
	}
}