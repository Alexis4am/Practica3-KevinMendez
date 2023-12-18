package ec.edu.ups.bibliotecadao.mainDao;

import ec.edu.ups.bibliotecadao.modelos.*;
import ec.edu.ups.bibliotecadao.controladores.*;
import ec.edu.ups.bibliotecadao.dao.*;
import ec.edu.ups.bibliotecadao.idaos.*;
import ec.edu.ups.bibliotecadao.vistas.*;

public class Principal {
	
	public static void main(String[] args) {
		
		IBibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		BibliotecaVista bibliotecaVista = new BibliotecaVista();
		
		IUsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVista usuarioVista = new UsuarioVista();
		
		ILibroDAO libroDAO = new LibroDAO();
		LibroVista libroVista = new LibroVista();
		
		IPrestamoDAO prestamoDAO = new PrestamoDAO();
		PrestamoVista prestamoVista = new PrestamoVista();
		
		BibliotecaControlador bibliotecaControlador = new BibliotecaControlador(bibliotecaDAO,bibliotecaVista,
				libroDAO,libroVista, usuarioDAO, usuarioVista);
		
		UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDAO, usuarioVista);
		
		LibroControlador libroControlador = new LibroControlador(libroDAO, libroVista);
		
		PrestamoControlador prestamoControlador = new PrestamoControlador(prestamoDAO, prestamoVista,
				libroDAO,libroVista, usuarioDAO, usuarioVista);
		
		
		//se crea biblioteca 
		bibliotecaControlador.crearBiblioteca(); 
		System.out.println("");
		//se crea usuario 
		usuarioControlador.crearUsuario();
		System.out.println("");
		//se crea librol 
		libroControlador.crearLibro();
		System.out.println("");
		//se crea libro2 
		libroControlador.crearLibro();
		System.out.println("");
		//se agrega libro a biblioteca
		bibliotecaControlador.agregarLibro();
		System.out.println("");
		//se registra usuario en biblioteca
		bibliotecaControlador.registrarUsuario();
		System.out.println("");
		//se crea prestamo y se busca por usuario
		prestamoControlador.crearPrestamo();
		System.out.println("") ;
		prestamoControlador.obtenerPrestamosPorUsuario();
		System.out.println("") ;
		System.out.println ("DATOS FINALES: \n") ;
		System.out.println ("SEPARACION DE INFORMACION—---\n");
		libroControlador.ListarLibro () ;
		System.out.println ("SEPARACION DE INFORMACION—---\n");
		usuarioControlador.listarUsuarios () ;
		System.out.println ("SEPARACION DE INFORMACION—---\n");
		prestamoControlador.listarPrestamos () ;
		System.out.println ("SEPARACION DE INFORMACION—---\n");

		
		
		/*
		Libro uno = new Libro("La gran zanahoria", "Juan Pazas", 1954);
		Biblioteca lol = new Biblioteca("La jornada Libreria","Benigno Malo");
		lol.agregarLibro(uno);
		System.out.println(lol.toString());
		*/
	}
	
	
}
