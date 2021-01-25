package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.Tarefa;

public class TarefaDaoImpl implements TarefaDao{

	@Override
	public Tarefa consultarPorNumero(Integer numTarefa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarefa> listarPorIdUsuario(Long idUsuario, Connection conn) throws Exception {
		
		try {
			
			Statement statement = conn.createStatement();

			String sql = "SELECT * FROM tb_tarefa "
						+ " where idusuario = " + idUsuario;

			ResultSet resultSet = statement.executeQuery(sql);
			
			List<Tarefa> listaTarefa = new ArrayList<Tarefa>();

			while (resultSet.next()) {
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getLong(1));
				tarefa.setTitulo(resultSet.getString(2));
				tarefa.setDescricao(resultSet.getString(3));
				tarefa.setMinutosTrabalhado(resultSet.getInt(4));	
				tarefa.setObservacao(resultSet.getString(5));	
				tarefa.setDataCriacao(resultSet.getDate(6));	
				tarefa.setIdUsuario(resultSet.getLong(7));
				
				listaTarefa.add(tarefa);

			}

			return listaTarefa;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage(), e);
		}
		
		
	}

	@Override
	public void incluir(Tarefa tarefa,  Connection conn) throws Exception {

		Statement statement = conn.createStatement();

		String sql = "INSERT INTO  tb_tarefa( \r\n"
				+ "titulo, descricao, minutostrabalhado, observacao, datacriacao, idusuario)\r\n"
				+ "	VALUES( " +
				"'" + tarefa.getTitulo() + "'," +
				"'" +tarefa.getDescricao() + "'," +
				    tarefa.getMinutosTrabalhado() + "," +
				"'" + tarefa.getObservacao() + "'," +
				"'" + new Date() + "'," +
				tarefa.getIdUsuario() + " )";

		statement.executeUpdate(sql);
	}

	
	

}
