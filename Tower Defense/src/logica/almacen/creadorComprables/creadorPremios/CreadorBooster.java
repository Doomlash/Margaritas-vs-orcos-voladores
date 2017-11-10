package logica.almacen.creadorComprables.creadorPremios;

import logica.almacen.*;
import logica.mapa.*;
import logica.visitor.visitorPowerUpYPremios.VisitorBooster;
import logica.premio.magiaTemporal.*;

public class CreadorBooster implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		m.getCelda(x, y).accept(new VisitorBooster(m, new PowerBooster(m)));
	}
}