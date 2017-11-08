package logica.almacen.creadorComprables;

import logica.almacen.*;
import logica.mapa.*;
import logica.comprables.*;

public class CreadorStun implements Creador{
	
	public void agregar(int x, int y, Mapa m){
		Stun s = new Stun(m.getAlmacenHilos(),m);
		if((m.getNivel().getPresupuesto()-s.getPrecio()>=0)){
			m.getNivel().modificarPresupueto(m.getNivel().getPresupuesto()-s.getPrecio());
			m.getAlmacenHilos().asignarStun(s);
		}
	}	
}