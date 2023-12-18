package ec.edu.ups.bibliotecadao.controladores;


import java.util.List;

import ec.edu.ups.bibliotecadao.dao.LibroDAO;
import ec.edu.ups.bibliotecadao.idaos.ILibroDAO;
import ec.edu.ups.bibliotecadao.modelos.Libro;
import ec.edu.ups.bibliotecadao.vistas.LibroVista;


public class LibroControlador {
	private ILibroDAO libroDAO;
	private LibroVista libroVista;
	private Libro libro;

	public LibroControlador(ILibroDAO libroDAO, LibroVista libroVista) {
		this.libroDAO = libroDAO;
		this.libroVista = libroVista;
	}
	
	public void crearLibro() {
		libro = libroVista.ingresarDatosLibro();
		libroDAO.crearLibro(libro);
	}
	
	public void actualizarLibro() {
		libro = libroVista.actualizarDatosLibro();
		if(libroDAO.actualizarLibro(libro.getTitulo(), libro) == true) {
			libroVista.mostrarAlertas("El libro a sido actualizado exitosamente");
		}else {
			libroVista.mostrarAlertas("ha ocurrido un error");
		}
	}
	public void eliminarLibro() {
		String nombreL = libroVista.eliminarLibro();
		if(libroDAO.eliminarLibro(nombreL) == true) {
			libroVista.mostrarAlertas("libro ha sido eliminado exitosamente");
		} else {
			libroVista.mostrarAlertas("ha ocurrido un error");
		}
	}
		
	public void buscarLibro() {
		String nombre = libroVista.buscarLibro();
		Libro libro1 = libroDAO.obtenerLibro(nombre);
		if(libro1 == null ) {
			libroVista.mostrarAlertas("No se ha encontrado el libro");
		}else {
			libroVista.mostrarInformacion(libro1.getTitulo(),libro1.getAutor(),libro1.getAnio());
		}
	}
	
	//FALTA OBTENER 
	public void ListarLibro() {
		List<Libro> listaLibros = libroDAO.obtenerLibros();
		for (Libro libro : listaLibros) {
			libroVista.mostrarInformacion(libro.getTitulo(),libro.getAutor(),libro.getAnio());
		}
	}
}
