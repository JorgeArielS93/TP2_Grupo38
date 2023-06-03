package ar.edu.unju.fi.model;

public class Producto {
	// Atributos
	private int codigoProducto=9 ;
	private String nombreProducto;
	private Double precioProducto;
	private String categoriaProducto;
	private String imagenProducto;
	private int descuentoProducto;
	
	// Constructores
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int codigoProducto, String nombreProducto, Double precioProducto, String categoriaProducto,
			String imagenProducto, int descuentoProducto) {
		super();
		this.codigoProducto = codigoProducto++;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.categoriaProducto = categoriaProducto;
		this.imagenProducto = imagenProducto;
		this.descuentoProducto = descuentoProducto;
	}
	//Metodos Get and Set
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
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
