package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
public class Sucursal {
	private String id;
	private String nombre;
	private String direccion;
	private String provincia;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate fechaInicio;
	private String email;
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