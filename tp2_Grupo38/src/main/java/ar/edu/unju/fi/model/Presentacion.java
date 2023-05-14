package ar.edu.unju.fi.model;

public class Presentacion {
	private String Titulo;
	private String Parrafo;

	public Presentacion() {

	}

	public Presentacion(String titulo, String parrafo) {
		super();
		Titulo = titulo;
		Parrafo = parrafo;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getParrafo() {
		return Parrafo;
	}

	public void setParrafo(String parrafo) {
		Parrafo = parrafo;
	}

}
