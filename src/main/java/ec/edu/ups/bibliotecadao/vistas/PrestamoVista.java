package ec.edu.ups.bibliotecadao.vistas;

import java.time.LocalDate;
import java.util.Scanner;


import ec.edu.ups.bibliotecadao.modelos.Prestamo;



public class PrestamoVista {
	private Scanner input;
	
	
	public PrestamoVista() {
		input = new Scanner(System.in);
		
	}
	
	public Prestamo ingresarDatosPrestamo() {
		
		System.out.println("------INGRESAR NUEVO PRESTAMO------");
        System.out.println("Ingresa el id del prestamo:");
        int id = input.nextInt();
        System.out.println("¿Deseas ingresar una nueva fecha de prestamo? (y/n): ");
        String respuesta = input.next();
        LocalDate fechaPrestamo;
        if(respuesta.equalsIgnoreCase("y")){
            System.out.println("Ingresa el dia: ");
            int dia = input.nextInt();
            System.out.println("Ingresa el mes: ");
            int mes = input.nextInt();
            System.out.println("Ingresa el año: ");
            int anio = input.nextInt();
            fechaPrestamo = LocalDate.of(anio,mes,dia);           
        }else{
            fechaPrestamo = LocalDate.now();
        }
        
        return new Prestamo(id, fechaPrestamo);
	}
	public Prestamo actualizarDatosPrestamo() {
		
		System.out.println("------ACTUALIZAR PRESTAMO------");
        System.out.println("Ingresa el id del prestamo a actualizar: ");
        int id = input.nextInt();
        System.out.println("¿Deseas ingresar una nueva fecha de prestamo? (y/n): ");
        String respuesta = input.next();
        LocalDate fechaPrestamo;
        if(respuesta.equalsIgnoreCase("y")){
            System.out.println("Ingresa el dia: ");
            int dia = input.nextInt();
            System.out.println("Ingresa el mes: ");
            int mes = input.nextInt();
            System.out.println("Ingresa el año: ");
            int anio = input.nextInt();
            fechaPrestamo = LocalDate.of(anio,mes,dia);           
        }else{
            fechaPrestamo = LocalDate.now();
        }
        
        return new Prestamo(id, fechaPrestamo);
	}
	public int eliminarPrestamo() {
		System.out.println("Ingresar la id del prestamo a eliminar: ");
		int id = input.nextInt();
		return id;
	}
	
	public int buscarPrestamo() {
		System.out.println("Ingresar la id del prestamo a buscar: ");
		int id = input.nextInt();
		return id;
	}
	
	public void mostrarInformacion(Prestamo prestamo) {
		System.out.println(prestamo.toString());
	}
	public void mostrarAlertas(String mensaje) {
		System.out.println(mensaje);
	}
	
}
