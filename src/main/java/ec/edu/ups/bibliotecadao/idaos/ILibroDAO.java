package ec.edu.ups.bibliotecadao.idaos;

import java.util.List;

import ec.edu.ups.bibliotecadao.modelos.Libro;

public interface ILibroDAO {
	List<Libro> obtenerLibros();
	Libro obtenerLibro(String titulo);
	void crearLibro(Libro libro);
	boolean actualizarLibro(String titulo, Libro libro);
	boolean eliminarLibro(String titulo);
	
}
