package logica.almacen.creadorComprables.creadorPremios;

import logica.premio.objetoPrecioso.*;
import logica.almacen.*;
import logica.mapa.*;
import logica.visitor.visitorPowerUpYPremios.*;

public class CreadorTrampa implements Accion{

	public void ejecutarAccion(int x, int y, Mapa m){
		Trampa t = new Trampa(x,y,m);
		if(m.getCelda(x, y).isEmpty()){
			m.agregarElemento(t);
			m.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Trampa");
		}
		else
			m.getCelda(x, y).getFirst().accept(new VisitorTrampa(m,t));
	}
}