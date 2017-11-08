package logica.visitor;

import logica.entidad.enemigo.*;
import logica.mapa.*;
import logica.mapa.elementosMapa.temporales.*;

public class VisitorMovimientoDragon extends VisitorMovimientoEnemigo{
	
	public VisitorMovimientoDragon(Dragon d, Mapa m){
		super(d,m);
	}

	public void visit(Agua a){
	}
}