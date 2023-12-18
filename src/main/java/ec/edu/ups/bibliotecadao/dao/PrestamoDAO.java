package ec.edu.ups.bibliotecadao.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.bibliotecadao.modelos.Libro;
import ec.edu.ups.bibliotecadao.modelos.Prestamo;
import ec.edu.ups.bibliotecadao.modelos.Usuario;

import ec.edu.ups.bibliotecadao.idaos.IPrestamoDAO;

public class PrestamoDAO implements IPrestamoDAO {
	List<Prestamo> listaPrestamos ;
	
	public PrestamoDAO() {
		listaPrestamos = new ArrayList<>();
	}

	@Override
	public Prestamo obtenerPrestamoPorLibro(Libro libro) {
		for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getLibro().getTitulo().equals(libro.getTitulo())){
                return prestamo;
            }
        }
		
		return null;
	}

	@Override
	public List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario) {
		List<Prestamo> prestamosUsusario = new ArrayList<>();
		for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getUsuario().getIdentificacion().equals(usuario.getIdentificacion())) {
            	prestamosUsusario.add(prestamo);
            }
        }
		return prestamosUsusario;
	}

	@Override
	public List<Prestamo> obtenerPrestamos() {
		return listaPrestamos;
	}

	@Override
	public Prestamo obtenerPrestamo(int id) {
		for(Prestamo prestamo : listaPrestamos) {
			if(prestamo.getId() == id) {
				return prestamo;
			}
		}
		return null;
	}

	@Override
	public void crearPrestamo(Prestamo prestamo) {
		listaPrestamos.add(prestamo);
		
	}

	@Override
	public boolean actualizarPrestamo(int id, Prestamo prestamo) {
		for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoEncontrado = listaPrestamos.get(i);
            if(prestamoEncontrado.getId() == id){
                listaPrestamos.set(i, prestamo);
                return true;
            }            
        }
        return false;
	}

	@Override
	public boolean eliminarPrestamo(int id) {
		for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoEncontrado = listaPrestamos.get(i);
            if(prestamoEncontrado.getId() == id){
                listaPrestamos.remove(i);
                return true;
            }            
        }
		return false;
	}
	
	
	
}
