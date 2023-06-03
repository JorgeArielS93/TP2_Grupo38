package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;
public class ListaProducto {
	private List<Producto> producto ;
	
	public ListaProducto () {
		producto = new ArrayList<>();
		producto.add(new Producto( 1, "Juguetes Cup Cake Cerezas Rascal", 2000.00 , "Juguete", "/images/cupcacke-cereza-300x300.jpg", 10 ));
		producto.add(new Producto( 2, "Juguetes  Cup Cake Rascal", 2000.00 , "Juguete", "/images/CUPCAKE-300x300.jpg", 20 ));
		
		producto.add(new Producto( 3, "Juguete Dispenser Con Pinchos Rascals", 2000.00 , "Juguete", "/images/dispenser-2-300x300.jpg", 30 ));
		producto.add(new Producto( 4, "Anillo Juguete dispensador de snack- Rascals", 2000.00 , "Juguete", "/images/Anillo-300x300.png", 10 ));
		
		producto.add(new Producto( 5, "Dog Selection Premium Adulto 21 Kg.", 2000.00 , "Alimento", "/images/alimento-perro2-300x300.png", 20 ));
		producto.add(new Producto( 6, "Vagoneta Perro Adulto 20Kg ", 2000.00 , "Alimento", "/images/alimento-perro3-300x300.png", 10 ));
		
		producto.add(new Producto( 7, "Cat Selection Adulto 10 Kg.", 2000.00 , "Alimento", "/images/alimento-gato1-300x300.png", 20 ));
		producto.add(new Producto( 8, "Infinity Gato Adulto 10 Kg. ", 2000.00 , "alimento", "/images/alimento-gato2-300x300.png", 10 ));
		
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	
	
	
	
	
}
