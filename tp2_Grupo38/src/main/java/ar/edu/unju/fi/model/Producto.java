package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class Producto {
	// Atributos
	private String codigoProducto;
	@NotEmpty(message = "El nombre no debe estar vacío")
	@Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
	private String nombreProducto;
	
	 @NotNull(message = "No debe estar vacío")
	 @Digits(integer = 10, fraction = 2, message = "El precio solo debe contener números")
	private Double precioProducto;
	
	@NotBlank(message="Debe seleccionar una categria")
	private String categoriaProducto;
	
	@NotEmpty(message="No debe estar Vacio")
	private String imagenProducto;
	
	@NotNull(message="Debe ingresar un valor de descuento")
	//@Pattern(regexp ="[0-9]+",message="El descuento solo debe tener numeros")
	private int descuentoProducto;
	
	private static int nextId = 1;// Variable para generar el ID incremental
	
	// Constructores
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String nombreProducto, Double precioProducto, String categoriaProducto,
			String imagenProducto, int descuentoProducto) {
		this.codigoProducto = "PROD-" + nextId++;// Generar el ID incremental
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.categoriaProducto = categoriaProducto;
		this.imagenProducto = imagenProducto;
		this.descuentoProducto = descuentoProducto;
	}
	public static int getNextId() {
		return nextId++;
	}

	public static void setNextId(int nextId) {
		Producto.nextId = nextId;
	}

	//Metodos Get and Set
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public String getCategoriaProducto() {
		return categoriaProducto;
	}
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	
	public String getImagenProducto() {
		return imagenProducto;
	}
	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}
	public int getDescuentoProducto() {
		return descuentoProducto;
	}
	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}
	
	// Metodos de Producto
		public double calcularDescuento(){
			double descontado=0;
			if (descuentoProducto >=0 && descuentoProducto <= 50) {
				descontado= precioProducto -((descuentoProducto * precioProducto)/100);
			}else {
				descontado= precioProducto;
			}
			return descontado;
		}
	
		public String mostrarPromo() {
			if (descuentoProducto > 0) { return "Ofertazo";} else{ return "";}
		}
	
}
