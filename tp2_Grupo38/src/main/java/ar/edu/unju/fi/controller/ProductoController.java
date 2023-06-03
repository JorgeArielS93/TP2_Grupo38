package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	ListaProducto listaProducto = new ListaProducto();
	
	@GetMapping("/listarProducto")
	public String getListarProducto(Model model) {
		model.addAttribute("producto", listaProducto.getProducto());
		model.addAttribute("activeProductos", true);
		return "productos";
	}
	
	@GetMapping("/nuevoproducto")
	public String getNuevaProductoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("producto", new Producto() );
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/guardarProducto")
	public String getGuardarProductoPage(@ModelAttribute("product") Producto producto) {
	    ModelAndView modelView = new ModelAndView("producto");
	    listaProducto.getProducto().add(producto);
	    modelView.addObject("producto", listaProducto.getProducto());
	    //return modelView;
	    return "redirect:/producto/listarProducto";
	}
	
	@GetMapping("/modificarProducto/{codProducto}")
	public String modificarConsejoPage(Model model , @PathVariable(value="codProducto")int codiProducto) {
		Producto productoEncontrado = new Producto();
		boolean edicion = true;
		for (Producto prod : listaProducto.getProducto()) {
			if (prod.getCodigoProducto() == codiProducto) {
				productoEncontrado = prod;
				break;
			}
			
		}
		model.addAttribute("product", productoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	@GetMapping("/eliminarProducto/{codProducto}")
	public String eliminarConsejoPage(Model model, @PathVariable(value="codProducto") int codigoProducto) {
	    for (Producto prod : listaProducto.getProducto()) {
	    	if (prod.getCodigoProducto() == codigoProducto) {
	    		listaProducto.getProducto().remove(prod);
	    	    break;
	    	}
	    }
	    return "redirect:/producto/listarProducto";
	}
	
	@PostMapping("/editar")
	public String modificarProducto(@ModelAttribute("codProducto") Producto producto) {
	    for (Producto prod : listaProducto.getProducto()) {
	        if (prod.getCodigoProducto() == producto.getCodigoProducto()) {
	        	prod.setCodigoProducto(producto.getCodigoProducto());
	        	prod.setNombreProducto(producto.getNombreProducto());
	        	prod.setPrecioProducto(producto.getPrecioProducto());
	        	prod.setCategoriaProducto(producto.getCategoriaProducto());
	        	prod.setImagenProducto(producto.getImagenProducto());
	        	prod.setDescuentoProducto(producto.getDescuentoProducto());
	        	
	        	break; // Agregar un break después de realizar las modificaciones
	        }
	    }
	    return "redirect:/producto/listarProducto";
	}
	
}
