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

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listarProducto")
	public String getListarProducto(Model model) {
		model.addAttribute("producto", productoService.getLista());
		model.addAttribute("activeProductos", true);
		return "productos";
	}
	
	@GetMapping("/nuevoproducto")
	public String getNuevaProductoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("producto", productoService.getProducto() );
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	/*
	 * @PostMapping("/guardarProducto") public ModelAndView
	 * getGuardarProductoPage(@Valid @ModelAttribute("product") Producto producto,
	 * BindingResult result) { ModelAndView modelView = new
	 * ModelAndView("productos"); if (result.hasErrors()) {
	 * modelView.setViewName("nuevo_producto"); modelView.addObject("producto",
	 * producto); return modelView; } productoService.guardar(producto);
	 * modelView.addObject("producto", productoService.getLista()); return
	 * modelView; }
	 */
	
	@PostMapping("/guardarProducto")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
	    ModelAndView modelView = new ModelAndView();
	    if (result.hasErrors()) {
	        modelView.setViewName("nuevo_producto");
	        modelView.addObject("producto", producto);
	        return modelView;
	    }
	    productoService.setId(producto);
	    productoService.guardar(producto);
	    modelView.setViewName("productos");
	    modelView.addObject("producto", productoService.getLista());
	    return modelView;
	}
	
	
	@GetMapping("/modificarProducto/{codProducto}")
	public String modificarConsejoPage(Model model , @PathVariable(value="codProducto")String codiProducto) {
		Producto productoEncontrado = productoService.getBy(codiProducto);
		boolean edicion = true;
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/editarProducto")
	public String modificarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "nuevo_producto";
		}
		productoService.modificar(producto);
	    return "redirect:/producto/listarProducto";
	}
	
	@GetMapping("/eliminarProducto/{codProducto}")
	public String eliminarConsejoPage(@PathVariable(value="codProducto") String codigoProducto) {
	    Producto productoEncontrado=productoService.getBy(codigoProducto);
	    productoService.eliminar(productoEncontrado);
	    return "redirect:/producto/listarProducto";
	}
	
}
