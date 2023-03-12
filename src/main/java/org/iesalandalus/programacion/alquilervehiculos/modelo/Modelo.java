package org.iesalandalus.programacion.alquilervehiculos.modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {
	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;
	
	public void comenzar() {

		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();
	}
	
	public void terminar() {
		System.out.println("El modelo ha terminado.");
	}


	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		
		if (turismo==null) 
			throw new NullPointerException();
		
		Turismo nuevo = new Turismo(turismo);
		this.turismos.insertar(nuevo);
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente==null) 
			throw new NullPointerException();

		Cliente nuevo = new Cliente(cliente);
		this.clientes.insertar(nuevo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler==null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		Cliente clienteBuscado = clientes.buscar(alquiler.getCliente());
		Turismo turismoBuscado = turismos.buscar(alquiler.getTurismo());
	
		if (clienteBuscado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		} else if (turismoBuscado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		} else {
		Alquiler alquilerNuevo = new Alquiler(clienteBuscado, turismoBuscado, alquiler.getFechaAlquiler());
			this.alquileres.insertar(alquilerNuevo);
		} 
	}
	
	public Cliente buscar(Cliente cliente) {
		Cliente clienteBuscado = new Cliente(clientes.buscar(cliente));
		return clienteBuscado;
	}

	public Turismo buscar(Turismo turismo) {
		Turismo turismoBuscado = new Turismo(turismos.buscar(turismo));
		return turismoBuscado;
	}

	public Alquiler buscar(Alquiler alquiler) {
		Alquiler alquilerBuscado = new Alquiler(alquileres.buscar(alquiler));
		return alquilerBuscado;
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		this.clientes.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechadevolucion) throws OperationNotSupportedException {
		if (alquiler == null) 
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		
		if (fechadevolucion == null) 
			throw new NullPointerException("ERROR: No se puede realizar una devolución nula.");
		
		if (this.alquileres.buscar(alquiler) == null) 
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		 
		alquiler.devolver(fechadevolucion);
	}
	
    public void borrar(Cliente cliente) throws OperationNotSupportedException {
        clientes.borrar(cliente);
    }

    public void borrar(Turismo turismo) throws OperationNotSupportedException {
        turismos.borrar(turismo);
    }

    public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
        alquileres.borrar(alquiler);
    }
    
    public List<Cliente> getClientes() {
    	List<Cliente> listaCopia = new ArrayList<>();
		for (Cliente it : clientes.get())
			listaCopia.add(new Cliente(it));
		return listaCopia;
    }

    public List<Turismo> getTurismos() {
    	List<Turismo> listaCopia = new ArrayList<>();
		for (Turismo it : turismos.get())
			listaCopia.add(new Turismo(it));
		return listaCopia;
    }

    public List<Alquiler> getAlquileres() {
    	List<Alquiler> listaCopia = new ArrayList<>();
		for (Alquiler it : alquileres.get())
			listaCopia.add(new Alquiler(it));
		return listaCopia;
    
    }

    public List<Alquiler> getAlquileres(Cliente cliente) {
    	List<Alquiler> listaCopia = new ArrayList<>();
        for (Alquiler it : alquileres.get(cliente))
        	listaCopia.add(new Alquiler(it));
        return listaCopia;
    }

    public List<Alquiler> getAlquileres(Turismo turismo) {
    	List<Alquiler> listaCopia = new ArrayList<>();
        for (Alquiler it : alquileres.get(turismo))
        	listaCopia.add(new Alquiler(it));
        return listaCopia;
    }
	
}	
