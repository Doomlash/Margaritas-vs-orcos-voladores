package logica.almacen.creadorComprables.creadorPremios;

import logica.almacen.Creador;
import logica.mapa.Mapa;
import logica.visitor.*;

public class CreadorBooster implements Creador{
	
	public void agregar(int x, int y, Mapa m){
		m.getCelda(x, y).accept(new VisitorBooster(m));
	}
}