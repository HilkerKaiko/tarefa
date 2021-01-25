package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;

import dto.LoginDto;
import entidade.Usuario;
import persistencia.UsuarioDaoImpl;

public class LogarNeg {

	
	public Usuario logarComCredenciais(Connection conn, BufferedReader bufRead) throws Exception {
		
		LoginDto usuarioDto = new LoginDto();
		UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		
		Boolean logado = false;
		
		while (!logado) {
			
			System.out.println("");

			System.out.println("Digite o nome do usuario:");
			usuarioDto.setLogin(bufRead.readLine());
			
			System.out.println("");


			System.out.println("Digite a senha:");
			usuarioDto.setSenha(bufRead.readLine());
			
			System.out.println("");

			
			usuario = usuarioDao.consultarPorNomeESenha(usuarioDto, conn);
			
			if (usuario == null || usuario.getId() == null) {
				
				System.out.println("Login ou senha incorreto. Digite novamente!");
				System.out.println("");
				
			} else {
				
		        System.out.println("Olá, " + usuario.getNome());
				System.out.println("");


				logado = true;
			}
			
			
		}
		
		
		
		
		
		return usuario;
	}

	public String inicializando(BufferedReader bufRead) {
		
		System.out.println("");

		System.out.println("Digite a opção desejada.");
		System.out.println("1 - Para Logar.");
		System.out.println("2 - Criar Usuario.");
		
		try {
			
		return bufRead.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
