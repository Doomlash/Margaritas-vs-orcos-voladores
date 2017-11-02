package logica.visitor;

import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;

public class VisitorAtaqueEnemigo extends Visitor{
	protected Enemigo ene;
	
	public VisitorAtaqueEnemigo(Enemigo e){
		ene=e;
	}
	
	public void visit(Aliado a){
		if(ene!=null){
			if(a.getX()+a.getDimensionX()==ene.getX())
				a.recibirGolpe(ene);
			if(ene!=null)
				ene.atacar(a);
		}
	}
	
	public void visit(Barricada b){
		if(ene!=null)
			ene.atacar(b);
	}
	public void visit(Piedra p){
		if(ene!=null)
			ene.atacar(p);
	}
	
	public void kill(){
		ene=null;
	}
}