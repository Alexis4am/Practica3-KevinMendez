package ec.edu.ups.bibliotecadao.modelos;

import java.util.ArrayList;



public class Usuario extends Persona {
	//SE IMPLEMENTA HERENCIA (Usuario Hereda a persona)
	private String correo;
	private ArrayList<Prestamo> listaPrestamo;
	
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
		listaPrestamo = new ArrayList<>();
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void agregarPrestamo(Prestamo prestamo) {
		listaPrestamo.add(prestamo);
	}

	public ArrayList<Prestamo> getListaPrestamo() {
		return listaPrestamo;
	}

	public void setListaPrestamo(ArrayList<Prestamo> listaPrestamo) {
		this.listaPrestamo = listaPrestamo;
	}
	
	//SE SOBREESCRIBE EL METODO ABSTRACTO DE PERSONA
	@Override
	public void mostrarInformacion() {
		System.out.println("Nombre: " + getNombre() + ", id: " + getIdentificacion());
		System.out.println("Correo: " + correo );
		
	}

	@Override
	public String toString() {
		return "Usuario [\n" +
		           "  Correo: " + correo + "\n" +
		           "]";

	}
}
