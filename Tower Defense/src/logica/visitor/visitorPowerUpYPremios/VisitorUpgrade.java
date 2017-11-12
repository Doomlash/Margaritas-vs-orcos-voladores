package logica.visitor.visitorPowerUpYPremios;

import logica.entidad.aliado.*;
import logica.comprables.*;
import logica.visitor.*;
import logica.mapa.*;

public class VisitorUpgrade extends Visitor{
	private Upgrade mejora;
	private Mapa map;
	
	public VisitorUpgrade(Mapa m, Upgrade u){
		this.map=m;
		this.mejora=u;
	}
	public void visit(Aliado a){
		a.getDirector().receive(mejora);
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()-mejora.getPrecio());
	}
	
	public void kill(){}
}