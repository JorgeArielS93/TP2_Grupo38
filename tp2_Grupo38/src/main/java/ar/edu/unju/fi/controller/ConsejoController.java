package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {
	ListaConsejo listaConsejo = new ListaConsejo();
	
	@GetMapping("/listarConsejo")
	public String getListarConsejo(Model model) {
		model.addAttribute("consejo", listaConsejo.getConsejo());
		model.addAttribute("activeConsejos", true);
		return "consejosDeSalud";
	}
	
	@GetMapping("/nuevoconsejo")
	public String getNuevaConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consej", new Consejo());
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardarconsejo")
	public String getGuardarSucursalPage(@ModelAttribute("consej") Consejo consejo) {
	    ModelAndView modelView = new ModelAndView("consejo");
	    listaConsejo.getConsejo().add(consejo);
	    modelView.addObject("consejo", listaConsejo.getConsejo());
	    //return modelView;
	    return "redirect:/consejo/listarConsejo";
	}
	
	
	
	@GetMapping("/modificarconsejo/{titulo}")
	public String modificarConsejoPage(Model model , @PathVariable(value="titulo")String titulo) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion = true;
		for (Consejo cons : listaConsejo.getConsejo()) {
			if (cons.getTitulo().equals(titulo)) {
				consejoEncontrado = cons;
				//cons.setTitulo(consej.);
				break;
			}
		}
		model.addAttribute("consej", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@GetMapping("/eliminarconsejo/{titulo}")
	public String eliminarConsejoPage(Model model , @PathVariable(value="titulo")String titulo) {
		for (Consejo cons : listaConsejo.getConsejo()) {
			if (cons.getTitulo().equals(titulo)) {
				listaConsejo.getConsejo().remove(cons);
			}
			break;
		}
		return "redirect:/consejo/listarConsejo";
	
	}	
}
