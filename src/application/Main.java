package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dto.LoginDto;
import entidade.Usuario;
import negocio.LogarNeg;
import negocio.LogarNeg;
import negocio.TarefaNeg;
import negocio.UsuarioNeg;
import persistencia.UsuarioDaoImpl;

public class Main {
	
	
    public static void main(String[] args) throws Exception {
    	
		InputStreamReader istream = new InputStreamReader(System.in);
		BufferedReader bufRead = new BufferedReader(istream);
		

        System.out.println(".....   Inicializando Tarefas .....");
		System.out.println("");


        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tarefa", "postgres", "hilker")) {
        	
        	Usuario usuario = new Usuario();
			LogarNeg logar = new LogarNeg();
			TarefaNeg tarefaNeg = new TarefaNeg();
			UsuarioNeg usuarioNeg = new UsuarioNeg();
			
			//Inicializando
			String opcao = logar.inicializando(bufRead);
			
			switch (opcao) {
			
			case "1": { // Logar
				
				usuario = logar.logarComCredenciais(conn, bufRead);
				

			}
			
			case "2": { // Criando usuario
				
				usuarioNeg.criarUsuario(bufRead, conn);
				
			}
			
			
			}
	
		}
	}
}
