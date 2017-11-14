package logica.visitor.visitorEnemigo;

import logica.entidad.enemigo.*;
import logica.mapa.*;
import logica.mapa.elementosMapa.temporales.*;
import logica.premio.objetoPrecioso.*;

public class VisitorMovimientoDragon extends VisitorMovimientoEnemigo{
	
	public VisitorMovimientoDragon(Dragon d, Mapa m){
		super(d,m);
	}

	public void visit(Agua a){
	}
	public void visit(Trampa t){
	}
}