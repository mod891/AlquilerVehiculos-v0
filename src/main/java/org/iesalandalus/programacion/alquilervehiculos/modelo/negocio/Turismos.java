package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;


public class Turismos {
	List<Turismo> turismos;
	
	public Turismos() {
		turismos = new ArrayList<>();
	}
	public List<Turismo> get() {
		return turismos;
	}
	public int getCantidad() {
		return turismos.size();
	}
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) 
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		if (turismos.contains(turismo))
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		
		turismos.add(turismo);
	}
	
	public Turismo buscar(Turismo turismo) {
		if (turismo == null) 
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		
		if (turismos.contains(turismo))
			return turismo;
		return null;
	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null)
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		if (turismos.contains(turismo))
			turismos.remove(turismo);
		else
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
	}
	
	
}
