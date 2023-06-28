package ar.edu.unju.fi.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
@Service
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ListaSucursal listaSucursales;
	@Autowired
	private Sucursal sucursal;

	@Override
	public List<Sucursal> getLista() {
		return listaSucursales.getSucursales();
	}

	@Override
	public void guardar(Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}

	@Override
	public Sucursal getBy(String id) {
		Sucursal sucursalEncontrada=null;
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(id)) {
				sucursalEncontrada=sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}

	@Override
	public void modificar(Sucursal sucursal) {
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(sucursal.getId())) {
				sucu.setNombre(sucursal.getNombre());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setEmail(sucursal.getEmail());
				sucu.setTelefono(sucursal.getTelefono());
			}
		}
		
	}

	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		listaSucursales.getSucursales().remove(sucursalEncontrada);
		
	}

	@Override
	public Sucursal getSucursal() {
		// TODO Auto-generated method stub
		return sucursal;
	}

	@Override
	// Asignar el ID incremental
	public void setId(Sucursal sucursal) {
		sucursal.setId("SUC-" + Sucursal.getNextId());
		
	}

}
