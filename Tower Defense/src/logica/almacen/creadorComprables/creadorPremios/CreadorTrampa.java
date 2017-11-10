package logica.almacen.creadorComprables.creadorPremios;

import logica.premio.objetoPrecioso.*;
import logica.almacen.*;
import logica.mapa.*;

public class CreadorTrampa implements Accion{

	public void ejecutarAccion(int x, int y, Mapa m){
		Trampa b = new Trampa(x,y,m);
	}
}