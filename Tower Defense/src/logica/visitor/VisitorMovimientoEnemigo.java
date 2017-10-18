package logica.visitor;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorMovimientoEnemigo extends Visitor{
	private Enemigo ene;
	
	public VisitorMovimientoEnemigo(Enemigo e){
		ene=e;
	}
	
	public void visit(Aliado a){
		if(ene!=null)
			ene.stop();
	}
	
	public void visit(Barricada b){
		if(ene!=null)
			ene.stop();
	}
	
	public void visit(Piedra p){
		if(ene!=null)
			ene.stop();
	}
	
	public void visit(Agua a){
	}
	
	public void visit(Trampa t){
	}
	
	public void kill(){
		ene=null;
	}

}