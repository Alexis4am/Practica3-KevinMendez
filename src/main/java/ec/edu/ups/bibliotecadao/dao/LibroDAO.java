package ec.edu.ups.bibliotecadao.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.bibliotecadao.idaos.ILibroDAO;
import ec.edu.ups.bibliotecadao.modelos.Libro;
public class LibroDAO implements ILibroDAO{
	
	private List<Libro> listaLibros;
	
	public LibroDAO() {
		listaLibros = new ArrayList<>();
	}

	@Override
	public List<Libro> obtenerLibros() {
		return listaLibros;
	}

	@Override
	public Libro obtenerLibro(String titulo) {
		for(Libro libroBuscar : listaLibros) {
			if(libroBuscar.getTitulo().equals(titulo)) {
				return libroBuscar;
			}
		}
		return null;
	}

	@Override
	public void crearLibro(Libro libro) {
		listaLibros.add(libro);
		
	}

	@Override
	public boolean actualizarLibro(String titulo, Libro libro) {
		for (int i = 0; i < listaLibros.size(); i++) {
			Libro libroActual = listaLibros.get(i);
			if(libroActual.getTitulo().equals(titulo)) {
				listaLibros.set(i, libro);
			}
		}
		return false;
	}

	@Override
	public boolean eliminarLibro(String titulo) {
		for (int i = 0; i < listaLibros.size(); i++) {
			Libro libroActual = listaLibros.get(i);
			if(libroActual.getTitulo().equals(titulo)) {
				listaLibros.remove(i);
				return true;
			}
		}
		return false;
	}
	

	
	
}
