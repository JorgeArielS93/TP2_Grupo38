package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Component
public class Servicio {
	private String id;
	@NotBlank(message="Debe ingresar DNI")
	@Pattern(regexp ="[0-9]+",message="El DNI solo debe tener numeros")
	@Size(min=8, max=8, message="El DNI debe tener 8 caracteres")
	@NotNull(message="Debe Ingresar DNI")
	private String dni;
	@NotBlank(message="Debe ingresar un Nombre")
	@Size(min=3, max=20, message="El Nombre debe tener entre 3 y 20 caracteres")
	@Pattern(regexp ="[a-zA-Z]+",message="El Nombre no debe tener numeros")
	private String nombre;
	@NotBlank(message="Debe ingresar Edad")
	@Pattern(regexp ="[0-9]+",message="Edad solo debe tener numeros")
	@Positive(message="La edad no debe ser negativo")
	private String edad;
	@NotBlank(message="Debe ingresar Domicilio")
	private String domicilio;
	@NotBlank(message="Debe ingresar Telefono")
	@Pattern(regexp ="[0-9]+",message="El Telefono solo debe tener numeros")
	@Size(min=10, max=12, message="El DNI debe tener 8 caracteres")
	private String telefono;
	@NotBlank(message="Debe ingresar Honorarios")
	@Pattern(regexp ="[0-9]+",message="Honorarios solo debe tener numeros")
	private String honorarios;
	private static int nextId = 1;
	
	public Servicio() {
		
	}

	public Servicio(String dni,String nombre, String edad, String domicilio, String telefono, String honorarios) {
		super();
		this.id = "PAS-" + nextId++;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.honorarios = honorarios;
	}
	public static int getNextId() {//método getNextId() para obtener el próximo ID incremental.
	    return nextId++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
