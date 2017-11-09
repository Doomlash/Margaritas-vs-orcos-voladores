package logica.visitor.visitorPowerUpYPremios;

import logica.premio.objetoPrecioso.*;
import logica.visitor.Visitor;
import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;

public class VisitorBomba extends Visitor{
	private Bomba bomba;
	
	public VisitorBomba(Bomba b){
		this.bomba=b;
	}

	public void visit(Aliado a){
		if(bomba!=null)
			a.recibirGolpe(bomba);
	}
	public void visit(Enemigo e){
		if(bomba!=null)
			e.recibirGolpe(bomba);
	}
	public void visit(Barricada b){
		if(bomba!=null)
			bomba.agregarObjetivo(b);
	}
	public void visit(Piedra p){
		if(bomba!=null)
			bomba.agregarObjetivo(p);
	}		
	public void visit(Trampa t){
		if(bomba!=null)
			bomba.agregarObjetivo(t);
	}
	
	public void kill(){
		this.bomba=null;
	}
}