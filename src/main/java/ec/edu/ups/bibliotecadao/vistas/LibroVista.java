package ec.edu.ups.bibliotecadao.vistas;

import java.util.Scanner;

import ec.edu.ups.bibliotecadao.modelos.Libro;


public class LibroVista {
	Scanner input;
	
	public LibroVista() {
		input = new Scanner(System.in);
	}
	
	public Libro ingresarDatosLibro() {
		System.out.println("---DATOS DE NUEVO LIBRO---");
		System.out.println("Ingresar el titulo del libro: ");
		String titulo = input.nextLine();
		System.out.println("Ingresar el autor del libro: ");
		String autor = input.nextLine();
		System.out.println("Ingresar el anio de publicacion del libro: ");
		int anio = input.nextInt();
		input.nextLine();
		return new Libro(titulo, autor, anio);
	}
	public Libro actualizarDatosLibro() {
		System.out.println("---ACTUALIZAR DATOS DE LIBRO---");
		
		System.out.println("Ingresar el titulo del libro a actualizar: ");
		String titulo = input.nextLine();
		System.out.println("Ingresar el autor del libro a actualizar: ");
		String autor = input.nextLine();
		System.out.println("Ingresar el anio de publicacion del libro a actualizar: ");
		int anio = input.nextInt();
		return new Libro(titulo, autor, anio);
	}
	public String eliminarLibro() {
		System.out.println("Ingresar el titulo del libro a eliminar: ");
		String titulo = input.nextLine();
		return titulo;
	}
	
	public String buscarLibro() {
		System.out.println("Ingresar el titulo del libro a buscar: ");
		String titulo = input.nextLine();
		return titulo;
	}
	
	
	public void mostrarInformacion(String titulo,String autor,int anio) {
		System.out.println("Datos del Libro: \n" + titulo + " - " + autor
		+ " - " + anio	);
	}
	public void mostrarAlertas(String mensaje) {
		System.out.println(mensaje);
	}
}
