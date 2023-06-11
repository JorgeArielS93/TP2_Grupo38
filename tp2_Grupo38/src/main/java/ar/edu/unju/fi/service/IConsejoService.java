package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {
	List<Consejo> getLista();
	void guardar(Consejo consejo);
	Consejo getBy(int numeroConsejo);
	void modificar(Consejo consejo);
	void eliminar (Consejo consejoEncontrado);
	Consejo getConsejo();
	void setId(Consejo consejo);
}
