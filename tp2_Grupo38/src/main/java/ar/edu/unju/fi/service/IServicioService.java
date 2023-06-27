package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Servicio;

public interface IServicioService {
	List<Servicio> getLista();

	void guardar(Servicio servicio);

	Servicio getBy(String id);

	void modificar(Servicio servicio);

	void eliminar(Servicio servicioEncontrado);

	Servicio getServicio();
	
	public void setId(Servicio servicio);
}
