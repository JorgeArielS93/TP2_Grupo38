package ar.edu.unju.fi.model;

public class Servicio {
	private String dni;
	private String paseador;
	private String edad;
	private String domicilio;
	private String telefono;
	private String honorarios;
	public Servicio() {
		
	}

	public Servicio(String dni,String nombre, String edad, String domicilio, String telefono, String honorarios) {
		super();
		this.dni = dni;
		this.paseador = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.honorarios = honorarios;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return paseador;
	}

	public void setNombre(String nombre) {
		this.paseador = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHonorarios() {
		return honorarios;
	}

	public void setHonorarios(String honorarios) {
		this.honorarios = honorarios;
	}
	
}
