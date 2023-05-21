package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Servicio;

public class ListaServicio {

	private List<Servicio> servicios;
	public ListaServicio() {

		servicios = new ArrayList<Servicio>();
		
		servicios.add(new Servicio("43654221","Maria Gomez","22" ,"B° Alto Comedero", "3886589084", "$500"));
		servicios.add(new Servicio("35621321","Roverto Vazquez", "26", "B° Chijra", "3884179993", "$700"));
		servicios.add(new Servicio("39156121","Juan Perez", "25", "B°Mariano Moreno", "3885044544", "$600"));
		servicios.add(new Servicio("36651615","Lucas Diaz", "28", "B° Huico", "3885765464", "$1200"));

	}
	
	public List<Servicio> getServicio() {
		return servicios;
	}

	public void setServicio(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	/*metodos accesores*/
}
