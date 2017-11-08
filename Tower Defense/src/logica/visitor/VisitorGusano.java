package logica.visitor;

import logica.comprables.*;
import logica.mapa.*;
import logica.entidad.enemigo.*;

public class VisitorGusano extends Visitor{
	private AgujeroGusano gusano;
	private Mapa map;
	
	public VisitorGusano(AgujeroGusano g, Mapa m){
		gusano=g;
		map=m;
	}
	
	public void visit(Enemigo e){
		map.agregarElemento(gusano);
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()-gusano.getPrecio());
	}
	
	
	public void kill(){}
}