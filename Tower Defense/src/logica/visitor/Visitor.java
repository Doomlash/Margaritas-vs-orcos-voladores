package logica.visitor;

import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;
import logica.mapa.elementosMapa.temporales.*;
import logica.premio.objetoPrecioso.*;

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
	public void visit(AgujeroGusano g){
		
	}
	public abstract void kill();
}