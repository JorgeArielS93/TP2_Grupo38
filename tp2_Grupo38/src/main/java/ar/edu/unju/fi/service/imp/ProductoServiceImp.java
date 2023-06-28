package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
@Service
public class ProductoServiceImp implements IProductoService {
	@Autowired
	private ListaProducto listaProductos;
	@Autowired
	private Producto producto;
	
	@Override
	public List<Producto> getLista() {
		return listaProductos.getProducto();
	}
	
	@Override
	public void guardar(Producto producto) {
		listaProductos.getProducto().add(producto);
	}
	
	@Override
	public Producto getBy(String codProducto) {
		Producto productoEncontrado= null;
		for(Producto prod : listaProductos.getProducto()) {
			if(prod.getCodigoProducto().equals(codProducto)) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado ;
	}
	
	@Override
	public void eliminar(Producto productoEncontrado) {
		listaProductos.getProducto().remove(productoEncontrado);
	}
	@Override
	public Producto getProducto() {
		return producto;
	}
	@Override
	public void setId(Producto producto) {
		producto.setCodigoProducto("PROD-"+Producto.getNextId());
	}

	@Override
	public void modificar(Producto producto) {
		for (Producto prod : listaProductos.getProducto()) {
			if (prod.getCodigoProducto().equals(producto.getCodigoProducto())) {
				prod.setCategoriaProducto(producto.getCategoriaProducto());
				prod.setDescuentoProducto(producto.getDescuentoProducto());
				prod.setImagenProducto(producto.getImagenProducto());
				prod.setNombreProducto(producto.getNombreProducto());
				prod.setPrecioProducto(producto.getPrecioProducto());
			}
		}
	}

	
}
