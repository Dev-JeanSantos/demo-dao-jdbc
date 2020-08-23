package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {
	//Instanciando o classe Conexao
	private Connection conn;
	//Instanciando DaoJDBC que entrega o Objeto Conexao para acessar em todas as classes
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor pesquisarPorId(Integer id) { //Buscar objeto Vendedor + departamento por VendedorId
		
		PreparedStatement st = null; //Iniciando estrutura sql com null
		ResultSet rs = null;//Inciando retorno dos dados do bd com null
		
		try {
			st = conn.prepareStatement( //sql que busca vendedor e departamento po vendedorId
					"SELECT vendedor .* "
					+ ", departamento.nome "
					+ "AS depNome"
					+" FROM vendedor "
					+ " INNER JOIN  departamento "
					+ "ON vendedor.departamentoid = departamento.id "
					+ "WHERE vendedor.id = ? ");
			
			st.setInt(1,id);//Entrada do vendedorId a pesquisar na consulta atraves "?"
			rs = st.executeQuery();//execução da query retornando para resultset
			if (rs.next()) { //condição de busca ate encontrar o ultimo dado no banco
				
								
				Departamento dep = new Departamento();//instanciando um Objeto Departamento
				dep.setId(rs.getInt("departamentoid"));//Setando a Variavel setId com o resultado deparatamentoId
				dep.setNome(rs.getString("depNome")); //Setando a Variavel setNome com o resultado deparatamentoNome
				
				Vendedor obj = new Vendedor();//instanciando um Objeto Vendedor
				obj.setId(rs.getInt("id"));//Setando a Variavel setId com o resultado vendedorId
				obj.setNome(rs.getString("nome"));//Setando a Variavel setNome com o resultado vendedorNome
				obj.setEmail(rs.getString("email"));//Setando a Variavel setEmail com o resultado vendedorEmail
				obj.setDataNascimento(rs.getDate("dataNascimento"));
				obj.setSalario(rs.getDouble("salario"));
				obj.setDepartamento(dep);//Associando o objeto departamento ao vendedor
				
				return obj;//retorna o objeto completo
			}
			return null; //se na pesquisar não encontra nada retorna null
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			
			DB.closeStatement(st);
			DB.closeResultaSet(rs);
			//não há necessidade de fechar a conexão pois outro metodos podem utiliza-lá
		}
	}

	@Override
	public List<Vendedor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}