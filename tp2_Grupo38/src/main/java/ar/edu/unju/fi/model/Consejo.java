package ar.edu.unju.fi.model;

public class Consejo {
	// Atributos
	private int numConsejo = 9;
	private String titulo;
	private String parrafo;
	private String imagen;

	// Constructores
	public Consejo(int numConsejo, String titulo, String parrafo, String imagen) {
		super();
		this.numConsejo = numConsejo++;
		this.titulo = titulo;
		this.parrafo = parrafo;
		this.imagen = imagen;
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
