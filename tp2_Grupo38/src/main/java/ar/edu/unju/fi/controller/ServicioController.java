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

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio")
	public class ServicioController{
	@Autowired
		private ListaServicio listaServicio; /* Inyecta el obejo listaservicio y se pone en el contenedor
		 													y el objeto ya esta creado en memoria listo para su uso, 
		 													con todos sus atributos y metodos*/
		
		@Autowired
		private Servicio servicio;
		
		@GetMapping("/listadoPaseador")
		public String getServicioDePaseos(Model model) {
			model.addAttribute("servicios", listaServicio.getServicio());
			model.addAttribute("activeServicio", true);
			return "servicio_de_paseos";
		}
		
		@GetMapping("/nuevoPaseador")
		public String getNuevoServicioPage(Model model) {
			boolean edicion=false;
			model.addAttribute("servicio",servicio);
			model.addAttribute("edicion",edicion);
			return "nuevo_servicio";
			
		}
		
		@PostMapping("/guardarServicio")
		public ModelAndView getGuardarServicioPage(@Valid @ModelAttribute("servicio") Servicio servicio,BindingResult result) {
		    ModelAndView modelView = new ModelAndView("servicio_de_paseos");
		    if(result.hasErrors())
		    {
		    	modelView.setViewName("nuevo_servicio");
		    	modelView.addObject("servicio",servicio);
		    	return modelView;
		    }
		    servicio.setId("PAS-" + Servicio.getNextId());
		    listaServicio.getServicio().add(servicio);
		    modelView.addObject("servicios",listaServicio.getServicio());
		    return modelView;
		}
		
		@GetMapping("/modificarPaseador/{id}")
		public String getEditarServicioPage(Model model,@PathVariable(value="id")String id){
			Servicio paseadorEncontrado =new Servicio();
			boolean edicion=true;
			for(Servicio servi : listaServicio.getServicio()) {
				if(servi.getId().equals(id)) {
				 paseadorEncontrado = servi;
				 break;
				}
			}
			model.addAttribute("servicio", paseadorEncontrado);
			model.addAttribute("edicion",edicion);
			return "nuevo_servicio";
		}
		
		@PostMapping("/modificarPaseador")
			public String modificarPaseador(@Valid @ModelAttribute("servicio")Servicio servicio,BindingResult result) {
			if(result.hasErrors()) {
				return "nuevo_servicio";
			}
				for(Servicio servi : listaServicio.getServicio())
				{
					if(servi.getId().equals(servicio.getId()))
					{
						servi.setDni(servicio.getDni());
						servi.setNombre(servicio.getNombre());
						servi.setEdad(servicio.getEdad());
						servi.setDomicilio(servicio.getDomicilio());
						servi.setTelefono(servicio.getTelefono());
						servi.setHonorarios(servicio.getHonorarios());				
					}
				}
				return "redirect:/servicio/listadoPaseador";		
			}	
		
		@GetMapping("/eliminarPaseador/{id}")
		public String eliminarPaseador(@PathVariable(value="id") String id) {
			
				for(Servicio servi: listaServicio.getServicio())
				{
					if (servi.getId().equals(id)) {
						listaServicio.getServicio().remove(servi);
						break;
					}
				}
				return "redirect:/servicio/listadoPaseador";
		}
}
			
		
		


