package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import modelo.dao.DaoFabrica;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("=== TESTE 1 - BUSCA VENDEDOR POR ID ===");
		VendedorDao vendedorDao = DaoFabrica.criarVendedorDao();
		Vendedor vendedor = vendedorDao.pesquisarPorId(1);		
		System.out.println(vendedor);
		
		System.out.println();
		System.out.println("=== TESTE 2 - BUSCA VENDEDOR POR DEPARTAMENTO ===");
		Departamento departamento = new Departamento(1, null);
		List<Vendedor> list = vendedorDao.buscarPorDepartamento(departamento);
		for(Vendedor obj : list) {
			System.out.println(obj);
			
		System.out.println();
		
		System.out.println("=== TESTE 3 - BUSCA VENDEDOR POR DEPARTAMENTO ===");
		list = vendedorDao.buscarTodos();
		for(Vendedor obj2 : list) {
			System.out.println(obj2);
			}	

		System.out.println();
		System.out.println("=== TESTE 4 - INSERIR NOVOS VENDEDORES ===");
		Vendedor newVendedor = new Vendedor(null, "Jean Santos", "jeancbsan@gmail.com",new java.sql.Date(sdf.parse("09/08/1977").getTime()) ,5500.0,departamento);
		vendedorDao.inserir(newVendedor);
		System.out.println("CADASTRO REGISTRADO COM SUCESSO! NOVO ID: " + newVendedor.getId());
		}
	}
}