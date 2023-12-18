package ec.edu.ups.bibliotecadao.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.bibliotecadao.idaos.IBibliotecaDAO;
import ec.edu.ups.bibliotecadao.modelos.Biblioteca;

public class BibliotecaDAO implements IBibliotecaDAO {
	List<Biblioteca> listaBibliotecas;
	
	public BibliotecaDAO() {
		listaBibliotecas = new ArrayList<>();
	}

	@Override
	public List<Biblioteca> obtenerBibliotecas() {
		
		return listaBibliotecas;
	}

	@Override
	public Biblioteca obtenerBiblioteca(String nombre) {
		for (Biblioteca biblioteca : listaBibliotecas) {
			if(biblioteca.getNombre().equals(nombre)) {
				return biblioteca;
			}
		}
		return null;
	}

	@Override
	public void crearBiblioteca(Biblioteca biblioteca) {
		listaBibliotecas.add(biblioteca);
		
	}

	@Override
	public boolean actualizarBiblioteca(String nombre, Biblioteca biblioteca) {
		for (int i = 0; i < listaBibliotecas.size(); i++) {
			Biblioteca bibliotecaActual = listaBibliotecas.get(i);
			if(bibliotecaActual.getNombre().equals(nombre)) {
				listaBibliotecas.set(i, biblioteca);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eliminarBiblioteca(String nombre) {
		for (int i = 0; i < listaBibliotecas.size(); i++) {
			Biblioteca bibliotecaActual = listaBibliotecas.get(i);
			if(bibliotecaActual.getNombre().equals(nombre)) {
				listaBibliotecas.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
}
