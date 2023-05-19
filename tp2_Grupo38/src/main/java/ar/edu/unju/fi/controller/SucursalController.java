package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/sucursal")//RequestMapping general para todas las peticiones de esta clase controlador.
public class SucursalController {
	ListaSucursal listaSucursales=new ListaSucursal();/*Contruye el objeto con el contructor por defecto,
	este contructor ya viene con un arraylist precargado con las sucursales.*/
	
    @GetMapping("/listado")
    public String getListaSucursalesPage(Model model) {
    	model.addAttribute("sucursales",listaSucursales.getSucursales());
        model.addAttribute("activeSucursal", true);
        return "sucursales";
    }
    @GetMapping("/nuevo")
    public String getNuevaSucursalPage(Model model) {
    	model.addAttribute("sucursal",new Sucursal());
    	return "nueva_sucursal";
    }
    @PostMapping("/guardar")
    public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
    	ModelAndView modelView = new ModelAndView("sucursales");
    	listaSucursales.getSucursales().add(sucursal);
    	modelView.addObject("sucursales",listaSucursales.getSucursales());
    	return modelView;
    }
}
