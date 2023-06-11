package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Consejo;
@Component
public class ListaConsejo {
	private List<Consejo> consejo ;
	
	public ListaConsejo() {
		//servicios = new ArrayList<Servicio>();
		consejo = new ArrayList<Consejo>();
		consejo.add(new Consejo(1,"Visita regularmente al veterinario."," Todos debemos de hacernos un chequeo médico al menos una vez al año para saber cómo estamos de salud. Lo mismo aplica para perros, gatos, roedores, reptiles, aves e incluso peces, ya que es recomendable hacerlos un chequeo veterinario general una vez al año.\r\n"
				+ "\r\n"
				+ "El veterinario nos orientará y diseñará un plan de prevención de las innumerables enfermedades que atacan a los animales de compañía, enseñándonos a cuidar de la mejor manera posible a nuestro compañero.\r\n"
				+ "\r\n"
				+ "En la primera visita de nuestro perro o gato al veterinario, éste se encargará de revisar su estado de salud y descartar cualquier patología, además de establecer el plan vacunal y de escoger las vacunas más adecuadas para cada animal según el riesgo de exposición a ciertas enfermedades y la zona de residencia.\r\n"
				+ "\r\n"
				+ "Por este motivo no existe un calendario de vacunación único. ","/images/mascota0.jpg"));
		
		consejo.add(new Consejo(2, "Desparasita con frecuencia a tu mascota.","La desparasitación de las mascotas debe llevarse a cabo antes de iniciar el suministro de las vacuna, porque además de eliminar los parásitos, el antiparasitario estimula las defensas y ayuda a que la vacuna produzca un mejor efecto inmune en los animales. ","/images/mascota1.jpg"));
		consejo.add(new Consejo(3, "Proporciónale una alimentación sana.",
				" Utiliza alimentos saludables, que cubran todas las necesidades nutricionales de tu mascota, aportando todos los elementos necesarios para un correcto crecimiento y desarrollo de la mascota, desde sus primeros años de vida hasta su etapa adulta.\r\n"
				+ "\r\n"
				+ "Ten en cuenta que las necesidades de tu mascota van cambiando a lo largo de su vida, por lo que proporciona lo que el animal necesite dependiendo de su estado fisiológico. Además es aconsejable repartir las comidas para evitar sobrecargar al animal y que tenga así mejores digestiones.\r\n"
				+ "\r\n"
				+ "Ten siempre a su disposición agua fresca y limpia, para que pueda hidratarse con regularidad. ", "/images/mascota2.jpg"));
		
		consejo.add(new Consejo(4, "No descuides su limpieza.", "Para huir de los parásitos externos (pulgas, garrapatas, piojos…) y de las enfermedades de la piel, el primer paso está en la prevención mediante un aseo periódico de tu mascota, de esta manera podremos detectar y tomar las medidas necesarias. ", "/images/mascota3.jpg"));
		
		consejo.add(new Consejo(5, "Limpia sus dientes con frecuencia.", " La higiene bucal es una práctica necesaria para evitar problemas en la boca, dientes y encías. Unos dientes y una boca sanos previenen de enfermedades, además de ser necesarios para una perfecta masticación interviniendo directamente en la correcta nutrición de la mascota.\r\n"
				+ "\r\n"
				+ "Por lo tanto cuida la boca de tu mascota, cepilla sus dientes o proporciona alimentos específicos para la limpieza bucal, previniendo de esta manera la aparición de caries, sarro, placa dental y mal aliento. No olvides visitar a tu veterinario para que valore el estado dental de tu mascota. ",  "/images/mascota4.jpg"));
		consejo.add(new Consejo(6, "Haz que realice ejercicio con frecuencia.", " Realizar dos paseos al día, salir a correr o jugar con tu mascota son ejercicios que no podemos olvidar para mantener el correcto estado de salud de tu mascota, y que esta pueda tener una vida plena, sana y feliz.\r\n"
				+ "\r\n"
				+ "De esta forma mejorarás el correcto funcionamiento intestinal y cardiovascular, y además prevendrás la obesidad de tu mascota. ",  "/images/mascota5.jpg"));
		consejo.add(new Consejo(7, "Evita los cambios bruscos de temperaturas.", " Evita las altas temperaturas en verano, dale agua fresca y limpia frecuentemente, evita los ejercicios intensos durante las hora de más calor, no olvides a tu mascota dentro del coche y evita las situaciones de estrés. Recuerda que con el calor los animales puede que no tengan tanto apetito.\r\n"
				+ "\r\n"
				+ "En invierno, al haber bajas temperaturas los animales necesitan ingerir más cantidad de energía por lo que puede aumentar su apetito, así que reparte las comidas para evitar sobrecargar su sistema digestivo.\r\n"
				+ "\r\n"
				+ "Cuidado con los cachorros y animales senior, ya que sus defensas no son las mismas que un animal adulto, por lo que evita largos periodos de tiempo al aire libre o abrígalos con prendas adecuadas, ten en cuenta los mismos consejos para mascota con pelo corto o sin capa protectora. ",  "/images/mascota6.jpg"));
		consejo.add(new Consejo(8, "Demuéstrale que le quieres.", "A las mascotas les gustan las caricias, así que procura hacerlas con frecuencia. Recuerda que el cariño ayuda a tu mascota a liberar estrés, relajarse y a sentirse querida. Además, está comprobado que las personas que acarician a sus mascotas también se sienten mejor. ",  "/images/mascota7.jpg"));
		
	}
	//get and set
	public List<Consejo> getConsejo() {
		return consejo;
	}

	public void setConsejo(List<Consejo> consejo) {
		this.consejo = consejo;
	}
	
	 
}
