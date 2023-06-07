package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
public class Sucursal {
	private String id;
	@NotEmpty(message = "El nombre no debe estar vacío")
	@Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
	/* Con el PAttern acepta nombres con tilde */
	@Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+", message = "El nombre solo puede contener letras y espacios")
	private String nombre;
	@NotNull(message = "Debe ingresar una Direccion")
	@Size(min=5, max=50,message = "La direccion debe contener entre 5 y 50 caracteres")
	private String direccion;
	
	@NotBlank(message = "Debe Seleccionar una Provincia")
	private String provincia;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Debe ingresar una fecha de Apertura")
	@Past(message = "La fecha debe ser menor a la fecha actual")
	private LocalDate fechaInicio;
	
	@NotBlank(message = "Debe ingresar un e-mail")
	@Email(message = "Debe ingresar un e-mail con formato valido")
	private String email;
	
	@NotBlank(message="Debe ingresar Telefono")
	@Pattern(regexp ="[0-9]+",message="El Telefono solo debe tener numeros")
	private String telefono;
	
	private static int nextId = 1;// Variable para generar el ID incremental
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}

	public Sucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email, String telefono) {
	    this.id = "SUC-" + nextId++;// Generar el ID incremental
	    this.nombre = nombre;
	    this.direccion = direccion;
	    this.provincia = provincia;
	    this.fechaInicio = fechaInicio;
	    this.email = email;
	    this.telefono = telefono;
	}
	
	 /* Cada vez que se cree una nueva sucursal desde el formulario, se generará 
	 * automáticamente un ID incremental.*/
	
	public static int getNextId() {//método getNextId() para obtener el próximo ID incremental.
	    return nextId++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}