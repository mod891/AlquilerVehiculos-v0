package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {
	List<Cliente> clientes;
	
	public Clientes() {
		clientes = new ArrayList<>();
	}
	
	public List<Cliente> get() {
		return clientes;
	}
	
	public int getCantidad() {
		return clientes.size();
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) 
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		if (clientes.contains(cliente))
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		
		clientes.add(cliente);
	}
	
	public Cliente buscar(Cliente cliente) {
		if (cliente == null) 
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		
		if (clientes.contains(cliente))
			return cliente;
		return null;
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null)
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		if (clientes.contains(cliente))
			clientes.remove(cliente);
		else
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null)
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		if (clientes.contains(cliente)) {
			if (nombre != null && !nombre.trim().isEmpty()) 
				cliente.setNombre(nombre);
			if (telefono != null && !telefono.trim().isEmpty()) 
				cliente.setTelefono(telefono);
		
			clientes.set(clientes.indexOf(cliente),cliente);
		} else
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
	}
	
}
