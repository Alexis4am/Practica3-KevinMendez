package ec.edu.ups.bibliotecadao.modelos;

import java.time.LocalDate;

public class Prestamo {
	private Libro libro;
	private Usuario usuario;
	private int id;
	private LocalDate fechaPrestamo;
	
	
	public Prestamo( int id, LocalDate fechaPrestamo) {
		this.id = id;
		this.fechaPrestamo = fechaPrestamo;
		
	}
	public Prestamo(Libro libro, Usuario usuario, int id, LocalDate fechaPrestamo) {
		this.libro = libro;
		this.usuario = usuario;
		this.id = id;
		this.fechaPrestamo = fechaPrestamo;
		
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Prestamo [\n" +
		           "  Libro: " + libro + "\n" +
		           "  Usuario: " + usuario + "\n" +
		           "  ID: " + id + "\n" +
		           "  Fecha de Préstamo: " + fechaPrestamo + "\n" +
		           "]";
	}




	
	
	
}
