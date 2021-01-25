package persistencia;

import java.sql.Connection;

import dto.LoginDto;
import entidade.Usuario;

public interface UsuarioDao {

	public Usuario consultarPorNomeESenha(LoginDto usuarioDto, Connection conn) throws Exception;
	
	void criarUsuario (Usuario usuario, Connection conn) throws Exception;
}
