package logica.visitor.visitorPowerUpYPremios;

import logica.visitor.*;
import logica.mapa.*;
import logica.premio.objetoPrecioso.*;
import logica.entidad.enemigo.*;

public class VisitorTrampa extends Visitor{
	private Mapa map;
	private Trampa trampa;
	
	public VisitorTrampa(Mapa m, Trampa t){
		this.map=m;
		this.trampa=t;
	}
	public void visit(Enemigo e){
		map.agregarElemento(trampa);
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Trampa");
	}
	public void kill(){}
}