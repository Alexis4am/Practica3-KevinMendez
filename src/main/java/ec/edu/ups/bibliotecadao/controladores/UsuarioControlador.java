package ec.edu.ups.bibliotecadao.controladores;

import java.util.List;

import ec.edu.ups.bibliotecadao.idaos.IUsuarioDAO;
import ec.edu.ups.bibliotecadao.modelos.Usuario;
import ec.edu.ups.bibliotecadao.vistas.UsuarioVista;

public class UsuarioControlador {
	private IUsuarioDAO usuarioDAO;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	
	public UsuarioControlador(IUsuarioDAO usuarioDAO, UsuarioVista usuarioVista) {
		this.usuarioDAO = usuarioDAO;
		this.usuarioVista = usuarioVista;
	}
	
	public void crearUsuario() {
		usuario = usuarioVista.ingresarDatosUsuario();
		usuarioDAO.crearUsuario(usuario);
	}
	
	public void actualizarUsuario() {
		usuario = usuarioVista.actualizarDatosUsuario();
		if(usuarioDAO.actualizarUsuario(usuario.getIdentificacion(), usuario) == true) {
			usuarioVista.mostrarAlertas("El usuario a sido actualizado exitosamente");
		}else {
			usuarioVista.mostrarAlertas("ha ocurrido un error");
		}
		
	}
	public void eliminarUsuario() {
		String id = usuarioVista.eliminarUsuario();
		if(usuarioDAO.eliminarUsuario(id) == true) {
			usuarioVista.mostrarAlertas("Usuario ha sido eliminado exitosamente");
		}else {
			usuarioVista.mostrarAlertas("Ha ocurrido un error");
		}
		
	}
	public void buscarUsuario() {
		String id = usuarioVista.buscarUsuario();
		Usuario usuario = usuarioDAO.obtenerUsuario(id);
		if (usuario == null) {
			usuarioVista.mostrarAlertas("No se ha encontrado al usuario");
		} else {
			usuarioVista.mostrarInformacion(usuario.getNombre(),usuario.getIdentificacion(),
					usuario.getCorreo());
		}
	}
	
	public void listarUsuarios() {
		List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();
		for(Usuario usuario : listaUsuarios) {
			usuarioVista.mostrarInformacion(usuario.getNombre(),usuario.getIdentificacion(),
					usuario.getCorreo());
		}
	}
}
