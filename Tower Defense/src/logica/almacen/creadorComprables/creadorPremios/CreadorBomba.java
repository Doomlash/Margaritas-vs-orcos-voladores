package logica.almacen.creadorComprables.creadorPremios;

import logica.almacen.*;
import logica.mapa.*;
import logica.premio.objetoPrecioso.*;

public class CreadorBomba implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		m.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Bomba");
		m.getAlmacenHilos().getBombas().agregarBomba(new Bomba(x,y,m));
	}
}