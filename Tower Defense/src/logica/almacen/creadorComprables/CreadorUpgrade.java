package logica.almacen.creadorComprables;

import logica.almacen.*;
import logica.mapa.*;
import logica.visitor.visitorPowerUpYPremios.*;
import logica.comprables.*;

public class CreadorUpgrade implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		Upgrade u = new Upgrade(m);
		if(m.getNivel().getPresupuesto()>=u.getPrecio()){
			m.getCelda(x, y).getFirst().accept(new VisitorUpgrade(m,u));
		}
	}
}