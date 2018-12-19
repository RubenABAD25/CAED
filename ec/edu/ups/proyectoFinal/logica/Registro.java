package ec.edu.ups.proyectoFinal.logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ec.edu.ups.proyectoFinal.entidad.Docente;

public class Registro {
	public static  ArrayList<Docente> docenteList= new ArrayList<Docente>();
	public void agregarDocente(Docente d){
		String cedula= d.getCedula();
		String apellido=d.getApellido();
		String nombre=d.getNombre();
		String email=d.getEmail();
		String direccion=d.getDireccion();
		String telefono=d.getTelefono();
		Date fechaNacimiento=d.getFechaNacimiento();
		String especialidad=d.getEpecialidad();
		Docente d1= new Docente(cedula, apellido, nombre, email, direccion, telefono, fechaNacimiento, especialidad);
		docenteList.add(d1);
		
	}
}
