package logica.visitor;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorAtaqueEnemigo extends Visitor{
	protected Enemigo ene;
	
	public VisitorAtaqueEnemigo(Enemigo e){
		ene=e;
	}
	
	public void visit(Aliado a){
		ene.atacar(a);
	}
	public void visit(Enemigo e){
	}
	public void visit(Barricada b){
		ene.atacar(b);
	}
	public void visit(Piedra p){
		ene.atacar(p);
	}
	public void visit(Agua a){
	}
	public void visit(Trampa t){
	}
}