package logica.visitor;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public abstract class Visitor{

	public abstract void visit(Aliado a);
	public abstract void visit(Enemigo e);
	public abstract void visit(Barricada b);
	public abstract void visit(Piedra p);
	public abstract void visit(Agua a);
	public abstract void visit(Trampa t);
}