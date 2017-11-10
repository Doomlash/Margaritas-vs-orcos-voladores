package logica.almacen.creadorComprables;

import logica.almacen.*;
import logica.mapa.*;
import logica.comprables.*;

public class CreadorCuracion implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		CampoDeCuracion c = new CampoDeCuracion(x,y,m);
		if((m.getNivel().getPresupuesto()-c.getPrecio()>=0)){
			m.getNivel().modificarPresupueto(m.getNivel().getPresupuesto()-c.getPrecio());
			m.getAlmacenHilos().getPowerUps().agregarPowerUp(c);
		}
	}
}