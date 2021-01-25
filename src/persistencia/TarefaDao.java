package persistencia;

import java.util.List;

import entidade.Tarefa;

public interface TarefaDao {

	
	public Tarefa consultarPorNumero(Integer numTarefa) throws Exception;


	public List<Tarefa> listarPorMatriculaUsuario(Integer numMatricula) throws Exception;


	public void incluir(Tarefa tarefa) throws Exception;

}
