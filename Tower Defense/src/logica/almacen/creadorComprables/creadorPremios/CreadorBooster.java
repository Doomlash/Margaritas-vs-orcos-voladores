package logica.almacen.creadorComprables.creadorPremios;

import logica.almacen.*;
import logica.mapa.*;
import logica.visitor.*;
import logica.premio.magiaTemporal.*;

public class CreadorBooster implements Creador{
	
	public void agregar(int x, int y, Mapa m){
		m.getCelda(x, y).accept(new VisitorBooster(m, new PowerBooster(x,y,m)));
	}
}