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
	ListaProducto listaProducto;
	@Autowired
	Producto producto;
	
	@Override
	public List<Producto> getLista() {
		// TODO Auto-generated method stub
		return listaProducto.getProducto();
	}
	
	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		listaProducto.getProducto().add(producto);
	}
	@Override
	public Producto getBy(int codProducto) {
		Producto productoEncontrado= null;
		for(Producto prod : listaProducto.getProducto()) {
			if(prod.getCodigoProducto() == codProducto) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado ;
	}
	
	@Override
	public void eliminar(Producto productoEncontrado) {
		// TODO Auto-generated method stub
		listaProducto.getProducto().remove(productoEncontrado);
	}
	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Producto producto) {
		// TODO Auto-generated method stub
		for(Producto prod : listaProducto.getProducto() ) {
			if ( prod.getCodigoProducto() == producto.getCodigoProducto()  )
				prod.setNombreProducto(producto.getNombreProducto());
				prod.setPrecioProducto( producto.getPrecioProducto() );
				prod.setCategoriaProducto(producto.getCategoriaProducto());
				prod.setImagenProducto(producto.getImagenProducto());
				prod.setDescuentoProducto(producto.getDescuentoProducto());
		}
	}

	
}
