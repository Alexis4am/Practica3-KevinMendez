package ec.edu.ups.bibliotecadao.idaos;

import java.util.List;

import ec.edu.ups.bibliotecadao.modelos.Libro;
import ec.edu.ups.bibliotecadao.modelos.Prestamo;
import ec.edu.ups.bibliotecadao.modelos.Usuario;

public interface IPrestamoDAO {
	Prestamo obtenerPrestamoPorLibro(Libro libro);
	List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario);
	
	List<Prestamo> obtenerPrestamos();
	Prestamo obtenerPrestamo(int id);
	void crearPrestamo(Prestamo prestamo);
	boolean actualizarPrestamo(int id, Prestamo prestamo);
	boolean eliminarPrestamo(int id);
	
	
}
