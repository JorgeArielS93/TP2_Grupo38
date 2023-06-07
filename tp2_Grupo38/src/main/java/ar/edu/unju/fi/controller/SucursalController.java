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
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;
import ar.edu.unju.fi.service.imp.SucursalServiceImp;
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
	private ICommonService commonService;
	@Autowired
	private ISucursalService sucursalService;
	
	/*
	* @Autowired private ListaSucursal listaSucursales;
	*//* Crea un objeto listaSucursales de la clase ListaSucursal con
	* el Constructor por defecto que inicializa la lista sucursales
	* como un ArrayList vacío y luego agrega objetos de tipo Sucursal
	*/
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		model.addAttribute("activeSucursal", true);//hover de la pagina
		return "sucursales";
	}

	/*
	 * @Autowired private Sucursal sucursal;
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal",sucursalService.getSucursal() );
		model.addAttribute("provincias",commonService.getProvincias());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("sucursales");
	    if (result.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("provincias",commonService.getProvincias());
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
	    sucursalService.setId(sucursal);
	    sucursalService.guardar(sucursal);
	    modelView.addObject("sucursales", sucursalService.getLista());
	    return modelView;
	}
	

	@GetMapping("/editar/{id}")
	public String getEditarSucursalPage(Model model, @PathVariable(value = "id") String id) {
		Sucursal sucursalEncontrada = sucursalService.getBy(id);
		boolean edicion = true;
		model.addAttribute("sucursal",sucursalEncontrada);
		model.addAttribute("provincias", commonService.getProvincias());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}

	
	@PostMapping("/editar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("provincias", commonService.getProvincias());
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "nueva_sucursal";
			
		}
		sucursalService.modificar(sucursal);

		return "redirect:/sucursal/listado";
	}
	 
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value="id")String id) {
		Sucursal sucursalEncontrada=sucursalService.getBy(id);
		sucursalService.eliminar(sucursalEncontrada);
		return"redirect:/sucursal/listado";
	}
}
