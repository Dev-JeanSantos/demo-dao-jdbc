package application;

import java.util.Date;

import modelo.dao.DaoFabrica;
import modelo.dao.VendedorDao;
import modelo.dao.impl.VendedorDaoJDBC;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento dep = new Departamento( 1, "TI");
		System.out.println(dep);
		
		Vendedor ven = new Vendedor(1, "Jean Santos", "jeancbsan@gmail.com",
				new Date() , 4400.00 , dep);		
		System.out.println(ven);
		
		VendedorDao vendedorDao = DaoFabrica.inserirVendedorDao();
	}

}
