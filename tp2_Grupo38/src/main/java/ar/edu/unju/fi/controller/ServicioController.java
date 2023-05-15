package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class ServicioController{
		
		@GetMapping("/servicio")
		public String getServicioDePaseos(Model model) {
			model.addAttribute("activeServicio", true);
			return "servicioDePaseos";
		}
}

