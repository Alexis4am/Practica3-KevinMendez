package ec.edu.ups.bibliotecadao.modelos;



public class Libro {
	
	private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;
    
    public Libro() {
		
	}
    
	public Libro(String titulo, String autor, int anio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		disponible = true;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
public boolean prestar() {
	if(disponible == true) {
		disponible = false;
		return true; //PRESTAMO A SIDO EXITOSA
	}else {
		return false; // El LIBRO NO ESTA DISPONIBLE
	}
	}
	
	public boolean devolver() {
		if(disponible =! true) {
			disponible = true;
			return true; //DEVOLUCION A SIDO EXITOSA
		}else {
			return false; //EL LIBRO NO A SIDO PRESTADO O YA ESTA DEVUELTO
		}
		}
	

	@Override
	public String toString() {
		return "Libro [\n" +
		           "  Título: " + titulo + "\n" +
		           "  Autor: " + autor + "\n" +
		           "  Año: " + anio + "\n" +
		           "  Disponible: " + disponible + "\n" +
		           "]";
	}
	
	
    
    
    
}
