package ec.edu.ups.proyectoFinal.entidad;

import java.util.Date;

public class Persona {
	private String cedula;
	private String apellido;
	private String nombre;
	private String email;
	private String direccion;
	private String telefono;
	private Date fechaNacimiento;

	
	public Persona(String cedula, String apellido, String nombre, String email, String direccion, String telefono,
			Date fechaNacimiento) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean validarCedula(){
		boolean retorno = false;
		return retorno;
	}
		
	public int calcularEdad(String cedula, Date fechaNacimiento){
		int retorno=0;
		
		return retorno;
	
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "AbstractPersona [cedula=" + cedula + ", apellido=" + apellido + ", nombre=" + nombre + ", email="
				+ email + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}
	
}
