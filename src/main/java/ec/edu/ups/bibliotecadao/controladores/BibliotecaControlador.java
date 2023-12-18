package ec.edu.ups.bibliotecadao.controladores;

import java.util.List;

import ec.edu.ups.bibliotecadao.dao.BibliotecaDAO;
import ec.edu.ups.bibliotecadao.dao.LibroDAO;
import ec.edu.ups.bibliotecadao.dao.UsuarioDAO;
import ec.edu.ups.bibliotecadao.idaos.IBibliotecaDAO;
import ec.edu.ups.bibliotecadao.idaos.ILibroDAO;
import ec.edu.ups.bibliotecadao.idaos.IUsuarioDAO;
import ec.edu.ups.bibliotecadao.modelos.Biblioteca;
import ec.edu.ups.bibliotecadao.modelos.Libro;
import ec.edu.ups.bibliotecadao.modelos.Usuario;
import ec.edu.ups.bibliotecadao.vistas.BibliotecaVista;
import ec.edu.ups.bibliotecadao.vistas.LibroVista;
import ec.edu.ups.bibliotecadao.vistas.UsuarioVista;


public class BibliotecaControlador {
	private IBibliotecaDAO bibliotecaDAO;
	private BibliotecaVista bibliotecaVista;
	private Biblioteca biblioteca;

	private ILibroDAO libroDAO;
	private LibroVista libroVista;
	private Libro libro;

	private IUsuarioDAO usuarioDAO;
	private UsuarioVista usuarioVista;
	private Usuario usuario;

	public BibliotecaControlador(IBibliotecaDAO bibliotecaDAO, BibliotecaVista bibliotecaVista,
			ILibroDAO libroDAO, LibroVista libroVista, IUsuarioDAO usuarioDAO, UsuarioVista usuarioVista) {
			this.bibliotecaDAO =  bibliotecaDAO;
			this.bibliotecaDAO = bibliotecaDAO;
			this.bibliotecaVista = bibliotecaVista;
			this.libroDAO = libroDAO;
			this.libroVista = libroVista;
			this.usuarioDAO = usuarioDAO;
			this.usuarioVista = usuarioVista;

			}

	
public void crearBiblioteca() {
		biblioteca = bibliotecaVista.ingresarDatosBiblioteca();
		bibliotecaDAO.crearBiblioteca(biblioteca);
}

	public void actualizarBiblioteca() {
		biblioteca = bibliotecaVista.actualizarDatosLibro();
		if(bibliotecaDAO.actualizarBiblioteca(biblioteca.getNombre(), biblioteca) == true) {
			bibliotecaVista.mostrarAlertas("El libro a sido actualizado exitosamente");
		}
		bibliotecaVista.mostrarAlertas("ha ocurrido un error");
	}
	
	
	public void agregarLibro() {
		String nombreBiblioteca = bibliotecaVista.agregarLibro();
		biblioteca = bibliotecaDAO.obtenerBiblioteca(nombreBiblioteca);
		if (biblioteca != null) {
			bibliotecaVista.mostrarAlertas("Informacion correcta... continuando...");
			String titulo = libroVista.buscarLibro();
			libro = libroDAO.obtenerLibro(titulo);
		if (libro != null) {
			biblioteca.agregarLibro(libro);
			libroVista.mostrarAlertas("Se ha agregado libro a biblioteca!");
		} else {
			libroVista.mostrarAlertas("No se a podido agregar libro...");
			}
		} else {
			bibliotecaVista.mostrarAlertas("No se a podido encontrar biblioteca...");
		}
	}

		public void registrarUsuario() {
		String nombreBiblioteca = bibliotecaVista.registrarUsuario();
		biblioteca = bibliotecaDAO.obtenerBiblioteca(nombreBiblioteca);
		if (biblioteca != null) {
			String id = usuarioVista.buscarUsuario();
			usuario = usuarioDAO.obtenerUsuario(id);
		if (usuario != null) {
			biblioteca.agregarUsuario(usuario);
			usuarioVista.mostrarAlertas("Se ha registrado usuario en biblioteca!");
		} else {
		usuarioVista.mostrarAlertas("No se a podido registrar usuario...");
			}
		} else {
		bibliotecaVista.mostrarAlertas("No se a podido encontrar biblioteca...");
		}
	}

	
	
	public void eliminarBiblioteca() {
		String nombreB = bibliotecaVista.eliminarBiblioteca();
		if(bibliotecaDAO.eliminarBiblioteca(nombreB)== true) {
			bibliotecaVista.mostrarAlertas("Biblioteca ha sido eliminado exitosamente");
		} else {
			bibliotecaVista.mostrarAlertas("Ha ocurrido un error");
		}
	}
	
	public void buscarBiblioteca() {
		String nombreB = bibliotecaVista.buscarBiblioteca();
		Biblioteca  bibliotecaEncontrar = bibliotecaDAO.obtenerBiblioteca(nombreB);
		if(bibliotecaEncontrar == null) {
			bibliotecaVista.mostrarAlertas("No se ha encontrado a la biblioteca");
		} else {
			bibliotecaVista.mostrarInformacion(bibliotecaEncontrar);
		}
		
	}
	
	//FALTA OBTENER 
	public void listarBiblioteca() {
		List<Biblioteca> listaBiblioteca =bibliotecaDAO.obtenerBibliotecas();
		for(Biblioteca biblioteca :listaBiblioteca) {
			bibliotecaVista.mostrarInformacion(biblioteca);
		}
	}
	
}
