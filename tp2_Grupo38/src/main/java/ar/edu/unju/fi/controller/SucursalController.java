package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursal") /*
								 * la anotación @RequestMapping("/sucursal") indica que todas las solicitudes
								 * que comiencen con "/sucursal" serán manejadas por los métodos de este
								 * controlador. Por ejemplo, si hay un método en el controlador con la
								 * anotación @GetMapping("/listado"), se mapeará a la URL "/sucursal/listado".
								 */
public class SucursalController {
	@Autowired
	private ListaSucursal listaSucursales;/* Crea un objeto listaSucursales de la clase ListaSucursal con
														 * el Constructor por defecto que inicializa la lista sucursales
														 * como un ArrayList vacío y luego agrega objetos de tipo
														 * Sucursal
														 */
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		model.addAttribute("activeSucursal", true);
		return "sucursales";
	}
	@Autowired
	private Sucursal sucursal;
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal",sucursal );
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("sucursales");
	    if (result.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
	    sucursal.setId("SUC-" + Sucursal.getNextId()); // Asignar el ID incremental desde el formulario
	    listaSucursales.getSucursales().add(sucursal);
	    modelView.addObject("sucursales", listaSucursales.getSucursales());
	    return modelView;
	}
	

	@GetMapping("/editar/{id}")
	public String getEditarSucursalPage(Model model, @PathVariable(value = "id") String id) {
		Sucursal sucursalEncontrada = new Sucursal();
		boolean edicion = true;
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(id)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}

	
	@PostMapping("/editar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
		if (result.hasErrors()) {

			return "nueva_sucursal";
		}
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(sucursal.getId())) {
				sucu.setNombre(sucursal.getNombre());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setEmail(sucursal.getEmail());
				sucu.setTelefono(sucursal.getTelefono());
				break; // Agregar un break después de realizar las modificaciones
			}
		}

		return "redirect:/sucursal/listado";
	}
	 
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value="id")String id) {
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getId().equals(id)) {
				listaSucursales.getSucursales().remove(sucu);
				break;
			}
		}
		return"redirect:/sucursal/listado";
	}
}
