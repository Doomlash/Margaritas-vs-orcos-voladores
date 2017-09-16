package logica.Visitor.VisitorColisiones;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;
import logica.mapa.elementosMapa.temporales.*;
import logica.comprables.*;
import logica.premio.objetoPrecioso.*;

public abstract class VisitorColision{
	
	public abstract boolean visit(Aliado a);
	public abstract boolean visit(Enemigo e);
	public abstract boolean visit(Barricada b);
	public abstract boolean visit(Piedra p);
	public abstract boolean visit(Agua a);
	public abstract boolean visit(Trampa t);
}