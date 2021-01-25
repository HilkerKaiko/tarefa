package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dto.LoginDto;
import entidade.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario consultarPorNomeESenha(LoginDto usuarioDto, Connection conn) throws Exception {

		try {

			Usuario usuario = new Usuario();

			Statement statement = conn.createStatement();

			String sql = "SELECT * FROM tb_usuario " + " where login = '" + usuarioDto.getLogin() + "' and   senha = '"
					+ usuarioDto.getSenha() + "'";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				usuario.setId(resultSet.getLong(1));
				usuario.setCpf(resultSet.getString(2));
				usuario.setMatricula(resultSet.getInt(3));
				usuario.setNome(resultSet.getString(4));	
				usuario.setDepartamento(resultSet.getString(5));	
				usuario.setFuncao(resultSet.getString(6));	
			}

			return usuario;

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public void criarUsuario(Usuario usuario, Connection conn) throws Exception {
		
		try {
			
			Statement statement = conn.createStatement();

			String sql = "INSERT INTO  tb_usuario( \r\n"
					+ "cpf, matricula, nome, departamento, funcao, login, senha)\r\n"
					+ "	VALUES( " +
					"'" + usuario.getCpf() + "'," +
					  usuario.getMatricula().toString() +  "," +
					"'" + usuario.getNome() + "'," +
					"'" + usuario.getDepartamento() + "'," +
					"'" + usuario.getFuncao() + "'," +
					"'" + usuario.getLogin() + "'," +
					"'" + usuario.getSenha() + "'    )";

			statement.executeUpdate(sql);

			
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		
		
	}

}
