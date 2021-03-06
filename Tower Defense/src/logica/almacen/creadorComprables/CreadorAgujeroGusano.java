package logica.almacen.creadorComprables;

import logica.almacen.*;
import logica.mapa.*;
import logica.comprables.*;
import logica.visitor.visitorPowerUpYPremios.VisitorGusano;

public class CreadorAgujeroGusano implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		AgujeroGusano g = new AgujeroGusano(x,y,m);
		if((m.getNivel().getPresupuesto()-g.getPrecio()>=0)){
			if(m.getCelda(x, y).isEmpty()){
				m.agregarElemento(g);
				m.getNivel().modificarPresupueto(m.getNivel().getPresupuesto()-g.getPrecio());
			}
			else
				m.getCelda(x, y).getFirst().accept(new VisitorGusano(g,m));
		}
	}
}