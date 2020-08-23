package modelo.dao;

import java.util.List;

import modelo.entidades.Vendedor;

public interface VendedorDao {
	
	void inserir (Vendedor obj);
	void update (Vendedor obj);
	void deletarPorId (Integer id);
	void pesquisarPorId (Integer id);
	List<Vendedor> buscarTodos();
}
