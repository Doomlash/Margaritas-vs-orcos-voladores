package logica.almacen.creadorComprables;

import logica.almacen.*;
import logica.mapa.*;
import logica.comprables.*;

public class CreadorArmadura implements Creador{
	
	public void agregar(int x, int y, Mapa m){
		Armadura a = new Armadura();
		if(m.getNivel().getPresupuesto()>=a.getPrecio()){
			
		}
	}
}