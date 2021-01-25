package negocio;

import java.io.BufferedReader;
import java.sql.Connection;
import java.util.List;

import entidade.Tarefa;
import entidade.Usuario;
import persistencia.TarefaDaoImpl;

public class TarefaNeg  {

	
	public void listarTarefas(Usuario usuario, Connection conn) throws Exception {

		
		
		 System.out.println(usuario.getNome() + " estamos listando suas tarefas.");
		 System.out.println("");
		 System.out.println("");
	     
		 TarefaDaoImpl tarefaDaoImpl = new TarefaDaoImpl();
		 
		 List<Tarefa> listaDeTarefa = tarefaDaoImpl.listarPorIdUsuario(usuario.getId(), conn);
		 
		 if (listaDeTarefa != null) {
			 
			 for (Tarefa tarefa : listaDeTarefa) {
				
				 System.out.println("");
				 System.out.println("");
				 System.out.println("----------------------------------------------------------------------------");
				 System.out.println("Tarefa Num. " + tarefa.getId());
				 System.out.println("Titulo =  " + tarefa.getTitulo());
				 System.out.println("Descricao =  " + tarefa.getDescricao());
				 System.out.println("Minutos Trabalhados =  " + tarefa.getMinutosTrabalhado());
				 System.out.println("Data Criação =  " + tarefa.getDataCriacao());
				 
			 }
			 
		 }	 
	}

	
	public void criarTarefas(Usuario usuario, Connection conn, BufferedReader bufRead) throws Exception {

		System.out.println("");
		System.out.println("      *************           Cadastro de Tarefas        ***************");
		System.out.println("");
		
		Tarefa tarefa = new Tarefa();

		System.out.println("Digite o Titulo do tarefa: ");
		tarefa.setTitulo(bufRead.readLine());
		System.out.println("");
		
		System.out.println("Digite uma Descrição: ");
		tarefa.setDescricao(bufRead.readLine());
		System.out.println("");
		
		System.out.println("Digite uma Observacao: ");
		tarefa.setObservacao(bufRead.readLine());
		System.out.println("");

		System.out.println("Digite os minutos trabalhados: ");
		tarefa.setMinutosTrabalhado(Integer.valueOf(bufRead.readLine()));
		System.out.println("");

		
		tarefa.setIdUsuario(usuario.getId());
		
		
		 TarefaDaoImpl tarefaDaoImpl = new TarefaDaoImpl();
		 tarefaDaoImpl.incluir(tarefa, conn);
		 
		System.out.println("Tarefa cadastrada com sucesso!");
		System.out.println("");

		System.out.println("      *************     Fim do Cadastro de Tarefa        ***************");


	}

}
