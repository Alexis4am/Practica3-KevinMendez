package ec.edu.ups.bibliotecadao.vistas;

import java.util.Scanner;

import ec.edu.ups.bibliotecadao.modelos.Biblioteca;


public class BibliotecaVista {
	Scanner input;
	
	public BibliotecaVista() {
		input = new Scanner(System.in);
		
	}
	
	public Biblioteca ingresarDatosBiblioteca() {
		System.out.println("---DATOS DE NUEVA BIBLIOTECA---");
		System.out.println("Ingresar el nombre de la biblioteca: ");
		String nombre = input.nextLine();
		System.out.println("Ingresar la direccion: ");
		String direccion = input.nextLine();
		
		return new Biblioteca(nombre, direccion);
	}
	
	public Biblioteca actualizarDatosLibro() {
		
		System.out.println("---DATOS DE BIBLIOTECA A ACTUALIZAR---");
		System.out.println("Ingresar el nombre de la biblioteca: ");
		String nombre = input.nextLine();
		System.out.println("Ingresar el autor del libro: ");
		String direccion = input.nextLine();
		return new Biblioteca(nombre, direccion);
	}
	
	public String eliminarBiblioteca() {
		System.out.println("---DATOS DE BIBLIOTECA A ELIMINAR---");
		System.out.println("Ingresar el nombre de la biblioteca a eliminar: ");
		String nombreBibli = input.nextLine();
		return nombreBibli;
	}
	public String buscarBiblioteca() {
		System.out.println("---DATOS DE BIBLIOTECA A BUSCAR---");
		System.out.println("Ingresar el nombre de la biblioteca a buscar: ");
		String nombreBibli = input.nextLine();
		return nombreBibli;
	}
	public String agregarLibro() {
		System.out.println("---BIBLIOTECA AGREGAR LIBRO---");
		System.out.println("Ingresar el nombre de la biblioteca a buscar: ");
		String nombreBibli = input.nextLine();
		return nombreBibli;
	}
	public String registrarUsuario() {
		System.out.println("---BIBLIOTECA REGISTRAR USUARIO---");
		System.out.println("Ingresar el nombre de la biblioteca a buscar: ");
		String nombreBibli = input.nextLine();
		return nombreBibli;
		
	}
	
	public void mostrarInformacion(Biblioteca biblioteca) {
		System.out.println(biblioteca.toString());
	}
	
	public void mostrarAlertas(String mensaje) {
		System.out.println(mensaje);
	}
}
