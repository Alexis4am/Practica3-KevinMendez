package ec.edu.ups.bibliotecadao.dao;

import java.util.ArrayList;

import java.util.List;

import ec.edu.ups.bibliotecadao.idaos.IUsuarioDAO;
import ec.edu.ups.bibliotecadao.modelos.Usuario;


public class UsuarioDAO implements IUsuarioDAO{

	private List<Usuario> listaUsuarios;
	
	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
	}

	
	public List<Usuario> obtenerUsuarios() {
		return listaUsuarios;
	}


	@Override
	public Usuario obtenerUsuario(String identificacion) {
		for( Usuario usuario : listaUsuarios) {
			if(usuario.getIdentificacion().equals(identificacion)) {
				return usuario;
			}
		}
		return null;
	}


	@Override
	public void crearUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
		
		
	}


	@Override
	public boolean actualizarUsuario(String identificacion, Usuario usuario) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario usuario1 = listaUsuarios.get(i);
			if ( usuario1.getIdentificacion().equals(identificacion) ){
				listaUsuarios.set(i, usuario);
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean eliminarUsuario(String identificacion) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario usuario1 = listaUsuarios.get(i);
			if ( usuario1.getIdentificacion().equals(identificacion)){
				listaUsuarios.remove(i);
				return true;
			}
		}
		return false;
	}

	
	
	
	
}
