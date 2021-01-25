package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;

import entidade.Usuario;
import persistencia.UsuarioDaoImpl;

public class UsuarioNeg {

	public void criarUsuario(BufferedReader bufRead, Connection conn) throws Exception {

		Usuario usuario = new Usuario();
		UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

		try {

			System.out.println("");

			System.out.println("      *************           Cadastro de Usuario        ***************");
			System.out.println("");

			System.out.println("Informe os dados basicos de usuario");
			System.out.println("");

			System.out.println("Digite o Nome:  ");
			usuario.setNome(bufRead.readLine());
			System.out.println("");

			System.out.println("Digite o CPF:  ");
			usuario.setCpf(bufRead.readLine());
			System.out.println("");

			System.out.println("Digite a Matricula:  ");
			usuario.setMatricula(Integer.valueOf(bufRead.readLine()));
			System.out.println("");

			System.out.println("Digite o Departamento:  ");
			usuario.setDepartamento(bufRead.readLine());
			System.out.println("");

			System.out.println("Digite a Função:  ");
			usuario.setFuncao(bufRead.readLine());
			System.out.println("");

			System.out.println("Digite o Login:  ");
			usuario.setLogin(bufRead.readLine());
			System.out.println("");

			System.out.println("Digite a Senha:  ");
			usuario.setSenha(bufRead.readLine());
			System.out.println("");

			usuarioDaoImpl.criarUsuario(usuario, conn);
			
			
			System.out.println("      *************     Fim do Cadastro de Usuario        ***************");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
