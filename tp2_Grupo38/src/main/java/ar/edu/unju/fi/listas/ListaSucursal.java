package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Sucursal;
@Component
public class ListaSucursal {
	private List<Sucursal> sucursales;
	/*Crea una lista de objetos de tipo Sucursal.*/
	public ListaSucursal() {
		/* Constructor por defecto que inicializa la lista sucursales como un ArrayList vacío y luego 
		 * agrega objetos de tipo Sucursal */

		sucursales = new ArrayList<Sucursal>();
		/* Instancio la lista sucursales como un ArrayList vacío*/
		
		sucursales.add(new Sucursal("CASA CENTRAL", "Av. Fuerza Aérea N° 215", "Jujuy", LocalDate.of(2000, 12, 03), "asd1@gmail.com", "3884000000"));
		sucursales.add(new Sucursal("SUCURSAL LAVALLE", "Lavalle N° 135", "Jujuy", LocalDate.of(2005, 10, 13), "asd2@gmail.com", "3884466540"));
		sucursales.add(new Sucursal("SUCURSAL DORREGO", "Dorrego N° 385", "Jujuy", LocalDate.of(2010, 02, 19), "asd3@gmail.com", "3884488640"));
		sucursales.add(new Sucursal("SUCURSAL SAN MARTÍN", "San Martín N°539", "Salta", LocalDate.of(2002, 07, 16), "asd4@gmail.com", "3884023500"));
		sucursales.add(new Sucursal("SUCURSAL BELGRANO", "Belgrano N°123", "Salta", LocalDate.of(2008, 05, 02), "asd5@gmail.com", "402048880"));
		sucursales.add(new Sucursal("SUCURSAL INDEPENDENCIA", "Independencia N°105", "Salta", LocalDate.of(2013, 9, 22), "asd6@gmail.com", "3884528640"));

		/* Agrego objetos de tipo Sucursal al ArrayList*/
	}
	
	/* En el código se crea una lista (`List<Sucursal> sucursales`) inicialmente porque `List` es una 
	 * interfaz en Java que define un contrato para las operaciones comunes de una lista, como agregar,
	 * eliminar y acceder a elementos. Sin embargo, `List` es una interfaz y no se puede instanciar
	 * directamente. Por lo tanto, se necesita una implementación concreta de `List` para crear un objeto.
	 * En este caso, se utiliza `ArrayList` como la implementación concreta de la interfaz `List`.
	 * `ArrayList` es una clase en Java que implementa la interfaz `List` y proporciona una implementación
	 * basada en un arreglo dinámico. Proporciona varias operaciones eficientes para manipular elementos en
	 * la lista, como agregar, eliminar y acceder a elementos en función de sus índices.
	 * Entonces, se crea una lista inicialmente porque "es una buena práctica" programar contra interfaces en
	 * lugar de implementaciones concretas. Luego, se instancia un objeto de tipo `ArrayList` y se asigna a
	 * la variable `sucursales`, convirtiendo así la lista en un `ArrayList` concreto que se puede utilizar
	 * para almacenar los objetos de tipo `Sucursal`.*/
	
	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
}