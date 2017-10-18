package logica.visitor;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public abstract class Visitor{

	public void visit(Aliado a){
		
	}
	public void visit(Enemigo e){
		
	}
	public void visit(Barricada b){
		
	}
	public void visit(Piedra p){
		
	}
	public void visit(Agua a){
		
	}
	public void visit(Trampa t){
		
	}
	public abstract void kill();
}