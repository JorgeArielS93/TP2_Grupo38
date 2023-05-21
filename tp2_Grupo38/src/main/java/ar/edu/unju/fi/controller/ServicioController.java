package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/servicio")
	public class ServicioController{
		ListaServicio listaServicio=new ListaServicio(); /* se contruye obejto con contructor por defecto*/
		
		@GetMapping("/listadoPaseador")
		public String getServicioDePaseos(Model model) {
			model.addAttribute("servicios", listaServicio.getServicio());
			model.addAttribute("activeServicio", true);
			return "servicio_de_paseos";
		}
		
		/*@GetMapping("/nuevoPaseador")
		public String getNuevoPaseadorPage(Model model) {
			
		}*/
		
		
		
}

