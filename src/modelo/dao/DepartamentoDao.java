package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public interface DepartamentoDao {
	
	void inserir (Departamento obj);
	void update (Departamento obj);
	void deletarPorId (Integer id);
	void pesquisarPorId (Integer id);
	List<Departamento> buscarTodos();
	
}
