package ec.edu.ups.bibliotecadao.controladores;

import java.util.List;

import ec.edu.ups.bibliotecadao.idaos.ILibroDAO;
import ec.edu.ups.bibliotecadao.idaos.IPrestamoDAO;
import ec.edu.ups.bibliotecadao.idaos.IUsuarioDAO;
import ec.edu.ups.bibliotecadao.modelos.Libro;
import ec.edu.ups.bibliotecadao.modelos.Prestamo;
import ec.edu.ups.bibliotecadao.modelos.Usuario;
import ec.edu.ups.bibliotecadao.vistas.LibroVista;
import ec.edu.ups.bibliotecadao.vistas.PrestamoVista;
import ec.edu.ups.bibliotecadao.vistas.UsuarioVista;

public class PrestamoControlador {

	private IPrestamoDAO prestamoDAO;
    private PrestamoVista prestamoVista;
    private Prestamo prestamo;
    
    private ILibroDAO libroDAO;
    private LibroVista libroVista;
    private Libro libro;
    
    private IUsuarioDAO usuarioDAO;
    private UsuarioVista usuarioVista;
    private Usuario usuario;

    public PrestamoControlador(IPrestamoDAO prestamoDAO, PrestamoVista prestamoVista, 
    ILibroDAO libroDAO, LibroVista libroVista, IUsuarioDAO usuarioDAO, UsuarioVista usuarioVista) {
        this.prestamoDAO = prestamoDAO;
        this.prestamoVista = prestamoVista;
        this.libroDAO = libroDAO;
        this.libroVista = libroVista;
        this.usuarioDAO = usuarioDAO;
        this.usuarioVista = usuarioVista;
    } 
    
    
    public void crearPrestamo() {
    	prestamo = prestamoVista.ingresarDatosPrestamo();
    	String usuario = usuarioVista.buscarUsuario();
    	//verifica que el prestamo se haga a un usuario existente
    	Usuario usuarioEncontrar = usuarioDAO.obtenerUsuario(usuario);
    	if(usuarioEncontrar != null) {
    		String libro = libroVista.buscarLibro();
    		Libro libroEncontrar = libroDAO.obtenerLibro(libro);
    		if(libroEncontrar != null && libroEncontrar.isDisponible()) {
    			
    			prestamoDAO.crearPrestamo(prestamo);
    			prestamo.setLibro(libroEncontrar);
    			prestamo.setUsuario(usuarioEncontrar);
    			prestamo.getUsuario().agregarPrestamo(prestamo);
    			prestamo.getLibro().prestar();
    			prestamoVista.mostrarAlertas("Prestamo a sido exitoso!!!");
    		}else {
    			libroVista.mostrarAlertas("Libro no ha sido encontrado/No esta disponible");
    		}
    	} else {
    		usuarioVista.mostrarAlertas("Usuario no ha sido encontrado");
    	}
    }
    
    public void actualizarPrestamo() {
    	prestamo = prestamoVista.actualizarDatosPrestamo();
    	if(prestamoDAO.actualizarPrestamo(prestamo.getId(), prestamo) == true) {
    		prestamoVista.mostrarAlertas("El prestamo ha sido actualizado exitosamente");
    	}else {
    		prestamoVista.mostrarAlertas("Ha ocurrido un error");
    	}
    }
    
    public void buscarPrestamo() {
    int id = prestamoVista.buscarPrestamo();
    prestamo = prestamoDAO.obtenerPrestamo(id);
    if (prestamo == null) {
    	prestamoVista.mostrarAlertas("No se ha podido obtener prestamos");
    }else { 
    	prestamoVista.mostrarInformacion(prestamo);
    	}
    }

    
    public void eliminarPrestamo() {
    	int eliminar = prestamoVista.eliminarPrestamo();
    	if(prestamoDAO.eliminarPrestamo(eliminar) == true) {
    		prestamo.getLibro().devolver();
    		prestamoVista.mostrarAlertas("Prestamo ha sido eliminado el prestamo");
    	}else {
    		prestamoVista.mostrarAlertas("Ha ocurrido un error");
    	}
    	
    }
    public void listarPrestamos() {
    	List<Prestamo> listaPrestamos = prestamoDAO.obtenerPrestamos();
    	for (Prestamo prestamo : listaPrestamos) {
			prestamoVista.mostrarInformacion(prestamo);
		}
    }
    
    
    public void obtenerPrestamoPorLibro() {
    	String titulo = libroVista.buscarLibro();
    	libro = libroDAO.obtenerLibro(titulo);
    	prestamo = prestamoDAO.obtenerPrestamoPorLibro(libro) ;
    	if (prestamo != null) {
    		prestamoVista.mostrarInformacion(prestamo) ;
    	}else {
    		libroVista.mostrarAlertas("No se ha encontrado libro") ;
    }
    }

    
    public void obtenerPrestamosPorUsuario() {
    	String nombre = usuarioVista.buscarUsuario();
    	if(nombre != null ) {
    		usuario = usuarioDAO.obtenerUsuario(nombre);
    		if(usuario != null) {
    			List <Prestamo> prestamos = prestamoDAO.obtenerPrestamosPorUsuario(usuario);
    			for(Prestamo prestamo : prestamos) {
    				prestamoVista.mostrarInformacion(prestamo);
    				prestamoVista.mostrarAlertas("Informacion correcta... continuando");
    			}
    		} else {
    			prestamoVista.mostrarAlertas("Usuario no encontrado");
    		}
    	}else {
    		prestamoVista.mostrarAlertas("ERROR");
    	}
    }
}
