package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Consejo {
	// Atributos
	private int numConsejo;
	@NotEmpty(message="No debe estar Vacio")
	private String titulo;
	@NotEmpty(message="No debe estar Vacio")
	@Size(min=10, max=250 ,message="Debe contener  entre 10 y 250 caracteres")
	private String parrafo;
	@NotEmpty(message="No debe estar Vacio")
	private String imagen;
	
	private static int nextId = 1;// Variable para generar el ID incremental
	// Constructores
	public Consejo(int numConsejo, String titulo, String parrafo, String imagen) {
		this.numConsejo = nextId++;
		this.titulo = titulo;
		this.parrafo = parrafo;
		this.imagen = imagen;
	}
	/* Cada vez que se cree un nuevo consejo desde el formulario, se generará 
	 * automáticamente un ID incremental.*/
	
	public static int getNextId() {//método getNextId() para obtener el próximo ID incremental.
		return nextId++;
	}

	public static void setNextId(int nextId) {
		Consejo.nextId = nextId;
	}

	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	// get and set
	public int getNumConsejo() {
		return numConsejo;
	}

	public void setNumConsejo(int numConsejo) {
		this.numConsejo = numConsejo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getParrafo() {
		return parrafo;
	}

	public void setParrafo(String parrafo) {
		this.parrafo = parrafo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
