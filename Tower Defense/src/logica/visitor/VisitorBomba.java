package logica.visitor;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorBomba extends Visitor {
	private static int damage=200;
public void visit(Aliado a){
		a.setVida(a.getVida()-damage);
	}
	public void visit(Enemigo e){
		e.setVida(e.getVida()-damage);
	}
	public void visit(Barricada b){
		b.setVida(b.getVida()-damage);
	}
	public void visit(Piedra p){
		p.setVida(p.getVida()-damage);
	}
	public void visit(Agua a){
	}
	public void visit(Trampa t){
	}
	public void kill(){}
}
