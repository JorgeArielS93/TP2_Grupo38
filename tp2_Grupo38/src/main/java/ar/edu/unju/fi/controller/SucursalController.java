package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SucursalController {
	/**
	 * Se agrega el parámetro Model al método getSucursalPage() para poder agregar la variable activeSucursal 
	 * al modelo. La variable activeSucursal se establece en true para indicar que la página de sucursal está 
	 * activa.
	 * En la plantilla Thymeleaf, uso la variable activeSucursal en la directiva th:classappend para agregar
	 * la clase active al enlace de "Sucursales" cuando corresponda.
	 * @param model
	 * @return
	 * Al acceder a la página de sucursal, se establecerá la variable activeSucursal en true en el controlador
	 * y la clase active se agregará al enlace de "Sucursales" en la plantilla Thymeleaf. Esto resaltará el
	 * enlace como activo según el estilo definido para la clase active.
	 */
    @GetMapping("/sucursal")
    public String getSucursalPage(Model model) {
        model.addAttribute("activeSucursal", true);
        return "sucursales";
    }
}
