package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
@Controller
public class ConsejoServiceImp implements IConsejoService {
	@Autowired
	private ListaConsejo listaConsejos;
	@Autowired
	private Consejo consejo;
	@Override
	public List<Consejo> getLista() {
		return listaConsejos.getConsejo();
	}

	@Override
	public void guardar(Consejo consejo) {
		listaConsejos.getConsejo().add(consejo);
	}

	@Override
	public Consejo getBy(int numeroConsejo) {
		Consejo consejoEncontrado =null;
		for (Consejo cons : listaConsejos.getConsejo()) {
			if(cons.getNumConsejo()==numeroConsejo) {
				consejoEncontrado = cons;
				break;
			}
		}
		return consejoEncontrado;
	}

	@Override
	public void modificar(Consejo consejo) {
		for (Consejo cons : listaConsejos.getConsejo()) {
			if (cons.getNumConsejo() == consejo.getNumConsejo()) {
				
				cons.setNumConsejo(consejo.getNumConsejo());
				cons.setTitulo(consejo.getTitulo());
				cons.setParrafo(consejo.getParrafo());
				cons.setImagen(consejo.getImagen());
				break;
			}
		}

	}

	@Override
	public void eliminar(Consejo consejoEncontrado) {
		listaConsejos.getConsejo().remove(consejoEncontrado);
		
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

	@Override
	// Asignar el ID incremental
	public void setId(Consejo consejo) {
		consejo.setNumConsejo(Consejo.getNextId());
		
	}

}
