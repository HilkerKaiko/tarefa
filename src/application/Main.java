package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import entidade.Usuario;
import negocio.LogarNeg;
import negocio.TarefaNeg;
import negocio.UsuarioNeg;

public class Main {
	

	
	
    public static void main(String[] args) throws Exception {
    	
		InputStreamReader istream = new InputStreamReader(System.in);
		BufferedReader bufRead = new BufferedReader(istream);
		
		Usuario usuario = new Usuario();
		LogarNeg logar = new LogarNeg();
		TarefaNeg tarefaNeg  = new TarefaNeg();
		UsuarioNeg usuarioNeg = new UsuarioNeg();
		

        System.out.println(".....   Inicializando Tarefas .....");
		System.out.println("");
		


        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tarefa", "postgres", "hilker")) {
        	
        	
			Boolean inicializar = false;
			
			while (!inicializar) {
				
				//Inicializando
				String opcao = logar.inicializando(bufRead);
				
				switch (opcao) {
				
				case "1": { // Logar
					
					usuario = new Usuario();
					usuario = logar.logarComCredenciais(conn, bufRead);
					
					System.out.println("");

					System.out.println("      *************          Tela de Tarefas        ***************");

					System.out.println("");

					
			        System.out.println("Digite a opção desejada.");
			        System.out.println("1 - Listar os tarefas.");
			        System.out.println("2 - Criar tarefa.");

			        
					System.out.println("");
					
					
			        if (bufRead.readLine().equals("1")) {
			        	
			        	 tarefaNeg.listarTarefas(usuario, conn);
			        	 
			        } else {
			        	
			        	tarefaNeg.criarTarefas(usuario, conn, bufRead);
			        }
					
					
					
					
			        System.out.println("Deseja deslogar e logar de novo? Sim ou Nao");
			        if (!bufRead.readLine().equals("Sim")) {
			        	inicializar = true;
			        }

				}
				
				case "2": { // Criando usuario
					
					usuarioNeg.criarUsuario(bufRead, conn);
						
				}
				
				
				}
			}
			
		}
	}
    
    
 
}
