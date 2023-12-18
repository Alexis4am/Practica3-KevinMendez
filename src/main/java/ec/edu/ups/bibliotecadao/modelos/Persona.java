package ec.edu.ups.bibliotecadao.modelos;



public abstract class Persona {
	private String nombre;
	private String identificacion;
	
	public Persona(String nombre, String identificacion) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
	}
	
	public abstract void mostrarInformacion();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}

	

	
	
	
	
	
	
}
