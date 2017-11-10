package logica.visitor;

import logica.entidad.aliado.*;
import logica.mapa.*;

public class VisitorVenta extends Visitor{
	private Mapa map;
	
	public VisitorVenta(Mapa m){
		this.map=m;
	}
	
	public void visit(Aliado a){
		int devolucion=a.getPrecio();
		if(a.getVida()<a.getVidaMax())
			devolucion/=2;
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()+devolucion);
		a.kill();
	}
	public void kill(){}
}