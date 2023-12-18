package ec.edu.ups.bibliotecadao.idaos;

import java.util.List;

import ec.edu.ups.bibliotecadao.modelos.Usuario;

public interface IUsuarioDAO {

	List<Usuario> obtenerUsuarios();
	Usuario obtenerUsuario(String identificacion);
	void crearUsuario(Usuario usuario);
	boolean actualizarUsuario(String identificacion, Usuario usuario);
	boolean eliminarUsuario(String identificiacion);
	
}
