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

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {
	@Autowired
	ListaConsejo listaConsejo;
	
	@Autowired
	private Consejo consej;
	
	@GetMapping("/listarConsejo")
	public String getListarConsejo(Model model) {
		model.addAttribute("consejo", listaConsejo.getConsejo());
		model.addAttribute("activeConsejos", true);
		return "consejosDeSalud";
	}
	
	@GetMapping("/nuevoconsejo")
	public String getNuevaConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consej", consej);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardarconsejo")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consej") Consejo consejo,BindingResult result) {
	    ModelAndView modelView = new ModelAndView("consejo");
	    if ( result.hasErrors()) {
	    	modelView.setViewName("nuevo_consejo");
	    	modelView.addObject("consej", consej);
	    	return modelView;
	    }
	    listaConsejo.getConsejo().add(consejo);
	    modelView.addObject("consejo", listaConsejo.getConsejo());
	    return modelView;
	    //return "redirect:/consejo/listarConsejo";
	}
	
	
	@GetMapping("/modificarconsejo/{numeroConsejo}")
	public String modificarConsejoPage(Model model , @PathVariable(value="numeroConsejo")int numeroConsejo) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion = true;
		for (Consejo cons : listaConsejo.getConsejo()) {
			if (cons.getNumConsejo()== numeroConsejo) {
				consejoEncontrado = cons;
				//cons.setTitulo(consej.);
				break;
			}
			
		}
		model.addAttribute("consej", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@GetMapping("/eliminarconsejo/{numeroConsejo}")
	public String eliminarConsejoPage(Model model, @PathVariable(value="numeroConsejo") int numeroConsejo) {
	    for (Consejo cons : listaConsejo.getConsejo()) {
	    	if (cons.getNumConsejo() == numeroConsejo) {
	    	    listaConsejo.getConsejo().remove(cons);
	    	    break;
	    	}
	    }
	    return "redirect:/consejo/listarConsejo";
	}
	
	@PostMapping("/editar")
	public String modificarConsejo(@ModelAttribute("consej") Consejo consejo) {
		
		int consej =consejo.getNumConsejo();
	    for (Consejo cons : listaConsejo.getConsejo()) {
	        if (cons.getNumConsejo() == consej) {
	        	
	        	cons.setNumConsejo(consejo.getNumConsejo());
	        	cons.setTitulo(consejo.getTitulo());
	        	cons.setParrafo(consejo.getParrafo());
	        	cons.setImagen(consejo.getImagen());
	        	
	        	break; // Agregar un break después de realizar las modificaciones
	        }
	    }

	    return "redirect:/consejo/listarConsejo";
	    
	}
}
