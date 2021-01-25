package persistencia;

import java.sql.Connection;
import java.util.List;

import entidade.Tarefa;

public interface TarefaDao {

	
	public Tarefa consultarPorNumero(Integer numTarefa) throws Exception;


	public List<Tarefa> listarPorIdUsuario(Long idUsuario,  Connection conn) throws Exception;


	public void incluir(Tarefa tarefa,  Connection conn) throws Exception;

}
