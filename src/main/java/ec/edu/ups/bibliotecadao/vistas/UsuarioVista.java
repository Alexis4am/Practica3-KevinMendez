package ec.edu.ups.bibliotecadao.vistas;

import java.util.Scanner;
import ec.edu.ups.bibliotecadao.modelos.Usuario;

public class UsuarioVista {
	
	private Scanner input;
	//Cuando se cree un UsuarioVista automaticamente se crea un Scanner llamado input
	public UsuarioVista() {
		input = new Scanner(System.in);
	}
	
	public Usuario ingresarDatosUsuario() {
		System.out.println("---DATOS DE NUEVO USUARIO---");
		System.out.println("Ingresar el nombre del Usuario: ");
		String nombre = input.nextLine();
		System.out.println("Ingresar la identificacion del Usuario: ");
		String identificacion = input.nextLine();
		System.out.println("Ingresar el correo electronico del Usuario: ");
		String correo = input.nextLine();
		return new Usuario(nombre, identificacion, correo);
	}
	public Usuario actualizarDatosUsuario() {
		System.out.println("---ACTUALIZAR DATOS DE USUARIO---");
		System.out.println("Ingresar el nombre de Usuario a actualizar: ");
		String nombre = input.nextLine();
		System.out.println("Ingresar identificacion de Usuario a actualizar: ");
		String identificacion = input.nextLine();
		System.out.println("Ingresar el correo electronico de Usuario a actualizar: ");
		String correo = input.nextLine();
		return new Usuario(nombre, identificacion, correo);
	}
	public String eliminarUsuario() {
		System.out.println("Ingresar la identificacion del Usuario a eliminar: ");
		String id = input.nextLine();
		return id;
	}
	
	public String buscarUsuario() {
		System.out.println("Ingresar la identificacion del Usuario a buscar: ");
		String id = input.nextLine();
		return id;
	}
	
	public void mostrarInformacion(String nombre, String identificacion, String correo) {
		System.out.println("Datos de Usuario: \n" + nombre + " - " + identificacion  
		+ " - " + correo		);
	}
	public void mostrarAlertas(String mensaje) {
		System.out.println(mensaje);
	}
	
	
	
}