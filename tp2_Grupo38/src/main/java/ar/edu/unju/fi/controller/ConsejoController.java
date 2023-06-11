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

import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {
	/*
	 * @Autowired ListaConsejo listaConsejo;
	 */
	
	@Autowired
	private IConsejoService consejoService;
	/* private Consejo consej; */
	
	@GetMapping("/listarConsejo")
	public String getListarConsejo(Model model) {
		model.addAttribute("consejo", consejoService.getLista());
		model.addAttribute("activeConsejo", true);
		return "consejos_de_salud";
	}
	
	@GetMapping("/nuevoconsejo")
	public String getNuevaConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consej", consejoService.getConsejo());
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardarconsejo")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consej") Consejo consejo, BindingResult result) {
	    ModelAndView modelView = new ModelAndView();
	    if (result.hasErrors()) {
	        modelView.setViewName("nuevo_consejo");
	        modelView.addObject("edicion", false);
	        modelView.addObject("consejo",consejo);
	        return modelView;
	    }
	    consejoService.setId(consejo);
	    consejoService.guardar(consejo);
	    modelView.setViewName("consejos_de_salud");
	    modelView.addObject("consejo", consejoService.getLista());
	    return modelView;
	}
	
	@GetMapping("/modificarconsejo/{numeroConsejo}")
	public String modificarConsejoPage(Model model , @PathVariable(value="numeroConsejo")int numeroConsejo) {
		Consejo consejoEncontrado = consejoService.getBy(numeroConsejo);
		boolean edicion = true;
		model.addAttribute("consej", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@GetMapping("/eliminarconsejo/{numeroConsejo}")
	public String eliminarConsejoPage(Model model, @PathVariable(value="numeroConsejo") int numeroConsejo) {
		Consejo consejoEncontrado=consejoService.getBy(numeroConsejo);
	    consejoService.eliminar(consejoEncontrado);
	    return "redirect:/consejo/listarConsejo";
	}
	
	@PostMapping("/editar")
	public String modificarConsejo(@Valid @ModelAttribute("consej") Consejo consejo, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			boolean edicion=true;
			model.addAttribute("edicion", edicion);
			return "nuevo_consejo";
		}
		consejoService.modificar(consejo);
	    return "redirect:/consejo/listarConsejo";
	    
	}
}
