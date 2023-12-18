package ec.edu.ups.bibliotecadao.modelos;

import java.util.ArrayList;



public class Biblioteca {

	private String nombre;
	private String direccion;
	private ArrayList<Libro> listaLibros;
	private ArrayList<Usuario> listaUsuarios;
	
	public Biblioteca() {
		
	}

	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		listaLibros = new ArrayList<>();
		listaUsuarios = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public void agregarLibro(Libro libro ) {
		listaLibros.add(libro);
	}
	
	public void agregarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	//implementar hashcode
	
	@Override
	public String toString() {
		return "Biblioteca [\n" +
		           "  Nombre: " + nombre + "\n" +
		           "  Dirección: " + direccion + "\n" +
		           "  Lista de Libros: " + listaLibros + "\n" +
		           "  Lista de Usuarios: " + listaUsuarios + "\n" +
		           "]";
	}
	
	
	
}
