package ec.edu.ups.proyectoFinal.entidad;

import java.util.Date;

public class Docente extends Persona{
	private String epecialidad;
	

	public Docente(String cedula, String apellido, String nombre, String email, String direccion, String telefono,
			Date fechaNacimiento) {
		super(cedula, apellido, nombre, email, direccion, telefono, fechaNacimiento);
		// TODO Auto-generated constructor stub
	}
	

	public Docente(String cedula, String apellido, String nombre, String email, String direccion, String telefono,
			Date fechaNacimiento, String epecialidad) {
		super(cedula, apellido, nombre, email, direccion, telefono, fechaNacimiento);
		this.epecialidad = epecialidad;
	}


	
	
	public String getEpecialidad() {
		return epecialidad;
	}

	public void setEpecialidad(String epecialidad) {
		this.epecialidad = epecialidad;
	}

	@Override
	public String toString() {
		return super.toString()+" >>>>> " +"Docente [epecialidad=" + epecialidad + "]";
	}

	
	

}
