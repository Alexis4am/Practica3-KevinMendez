package ec.edu.ups.bibliotecadao.idaos;


import java.util.List;

import ec.edu.ups.bibliotecadao.modelos.Biblioteca;


public interface IBibliotecaDAO {
	List<Biblioteca> obtenerBibliotecas();
    Biblioteca obtenerBiblioteca(String nombre);
    void crearBiblioteca(Biblioteca biblioteca);
    boolean actualizarBiblioteca(String nombre, Biblioteca biblioteca);
    boolean eliminarBiblioteca(String nombre);
}
