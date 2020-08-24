package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.dao.DaoFabrica;
import modelo.dao.DepartamentoDao;
import modelo.entidades.Departamento;

public class ProgramaDepartamento {

	public static void main(String[] args) {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========== BUSCAR TODOS DEPARTAMENTOS =====================");
		DepartamentoDao departamentoDao = DaoFabrica.iniciarDepartamentoDao();
		List<Departamento> list = new ArrayList<Departamento>();
		list = departamentoDao.buscarTodos();
		for(Departamento dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("========== INSERIR DEPARTAMENTO =====================");
		System.out.print("NOME NOVO DEPARTAMENTO: ");
		String nomeDepar = sc.next();
		
		
		Departamento departamento = new Departamento(null, nomeDepar);
		//departamentoDao.inserir(departamento);
		System.out.println("NOVO DEPARTAMENTO CADASTRADO COM SUCESSO! NOVO ID: " + departamento.getId());
		
		System.out.println("========== PESQUISAR DEPARTAMENTO POR ID =====================");
		System.out.print("INSIRA O ID PARA INICIAR A BUSCA: ");
		int idDepartamento = sc.nextInt();
		
		departamento = departamentoDao.pesquisarPorId(idDepartamento);
		System.out.println(departamento);
		
				
		System.out.println("========== UPDATE NOME DEPARTAMENTO =====================");
		System.out.print("INSIRA O ID DO DEPARTAMENTO PARA ATUALZIAR O NOME: ");
		int idDepartamento2 = sc.nextInt();
		
		departamento = departamentoDao.pesquisarPorId(idDepartamento2);
		System.out.print("INSIRA O NOME ATUALIZADO: ");
		String nomeAtualizar = sc.next();
		departamento.setNome(nomeAtualizar);
		departamentoDao.update(departamento);
		
		System.out.println("========== DELETA DEPARTAMENTO POR ID =====================");
		System.out.print("INSIRA O ID A SER DELETADO: ");
		int idDepart = sc.nextInt();
		departamentoDao.deletarPorId(idDepart);
		System.out.println("DEPARTAMENTO EXCLUÍDO COM SUCESSO");
		
		
		
		
		System.out.println("========== BUSCAR TODOS DEPARTAMENTOS =====================");
		list = departamentoDao.buscarTodos();
		for(Departamento dep : list) {
			System.out.println(dep);
		}
		
		
		sc. close();

	}

}
