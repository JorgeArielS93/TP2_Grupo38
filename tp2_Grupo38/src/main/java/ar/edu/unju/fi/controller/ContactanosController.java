package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactanosController {
	/**
	 * Se agrega el parámetro Model al método getIndexPage() para poder agregar la variable activeContacto 
	 * al modelo. La variable activeContacto se establece en true para indicar que la página de contacto está
	 * activa.
	 * En la plantilla Thymeleaf, puedo usar la variable activeContacto en la directiva th:classappend para
	 * agregar la clase active al enlace de contacto cuando corresponda.
	 * @param model
	 * @return
	 * Al acceder a la página de contacto, se establecerá la variable activeContacto en true en el
	 * controlador y la clase active se agregará al enlace de contacto en la plantilla Thymeleaf.
	 * Esto resaltará el enlace como activo según el estilo definido para la clase active.
	 */
    @GetMapping("/contacto")
    public String getIndexPage(Model model) {
        model.addAttribute("activeContacto", true);
        return "contactanos";
    }
}
