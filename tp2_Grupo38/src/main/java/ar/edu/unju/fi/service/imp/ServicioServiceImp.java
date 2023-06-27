package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;

@Service
public class ServicioServiceImp implements IServicioService {
	@Autowired
	private ListaServicio listaServicios;
	
	@Autowired
	private Servicio servicio;

	@Override
	public List<Servicio> getLista() {
		return listaServicios.getServicio();
	}

	@Override
	public void guardar(Servicio servicio) {
		listaServicios.getServicio().add(servicio);
		
	}

	@Override
	public Servicio getBy(String id) {
		Servicio servicioEncontrado=null;
		for (Servicio servi : listaServicios.getServicio()) {
			if (servi.getId().equals(id)) {
				servicioEncontrado=servi;
				break;
			}
		}
		return servicioEncontrado;
	}

	@Override
	public void modificar(Servicio servicio) {
		for (Servicio servi : listaServicios.getServicio()) {
			if (servi.getId().equals(servicio.getId())) {
				servi.setDni(servicio.getDni());
				servi.setDomicilio(servicio.getDomicilio());
				servi.setEdad(servicio.getEdad());
				servi.setHonorarios(servicio.getHonorarios());
				servi.setNombre(servicio.getNombre());
				servi.setTelefono(servicio.getTelefono());
			}
		}
		
	}

	@Override
	public void eliminar(Servicio servicioEncontrado) {
		listaServicios.getServicio().remove(servicioEncontrado);
		
	}

	@Override
	public Servicio getServicio() {
		// TODO Auto-generated method stub
		return servicio;
	}

	@Override
	public void setId(Servicio servicio) {
		servicio.setId("PAS-" + Servicio.getNextId());
		
	}



}
