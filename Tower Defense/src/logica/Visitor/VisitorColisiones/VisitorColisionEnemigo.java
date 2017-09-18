package logica.Visitor.VisitorColisiones;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;
import logica.mapa.elementosMapa.temporales.*;
import logica.comprables.*;
import logica.premio.objetoPrecioso.*;

public class VisitorColisionEnemigo extends VisitorColision{
	
	/*
	 * Cada m�todo retorna un booleano indicando si el tipo recibido es atacable o no por un enemigo.
	 * (non-Javadoc)
	 * @see logica.Visitor.VisitorColisiones.VisitorColision#visit(logica.entidad.aliado.Aliado)
	 */
	
	public boolean visit(Aliado a){
		return true;
	}
	public boolean visit(Enemigo e){
		return false;
	}
	public boolean visit(Barricada b){
		return true;
	}
	public boolean visit(Piedra p){
		return true;
	}
	public boolean visit(Agua a){
		return false;
	}
	public boolean visit(Trampa t){
		return false;
	}
}