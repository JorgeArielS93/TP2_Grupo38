package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	/**
	 * Se agrega el parámetro Model al método getIndexPage() para poder agregar la variable activeInicio 
	 * al modelo. La variable activeInicio se establece en true para indicar que la página de inicio está 
	 * activa.
	 * En la plantilla Thymeleaf, uso la variable activeInicio en la directiva th:classappend para agregar
	 * la clase active al enlace de "Inicio" cuando corresponda.
	 * @param model
	 * @return
	 * Al acceder a la página de inicio, se establecerá la variable activeInicio en true en el controlador
	 * y la clase active se agregará al enlace de "Inicio" en la plantilla Thymeleaf. Esto resaltará el
	 * enlace como activo según el estilo definido para la clase active.
	 */
    @GetMapping("/inicio")
    public String getIndexPage(Model model) {
        model.addAttribute("activeInicio", true);
        return "index";
    }
}