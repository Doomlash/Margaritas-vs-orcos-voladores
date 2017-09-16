package logica.Visitor.VisitorInteraccion;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorAtaqueEnemigo extends VisitorInteraccion{
	protected Enemigo ene;
	
	public VisitorAtaqueEnemigo(Enemigo e){
		ene=e;
	}
	
	public void visit(Aliado a){
		a.setVida(a.getVida()-ene.getFuerza());
	}
	public void visit(Enemigo e){
	}
	public void visit(Barricada b){
		b.setVida(b.getVida()-ene.getFuerza());
	}
	public void visit(Piedra p){
		p.setVida(p.getVida()-ene.getFuerza());
	}
	public void visit(Agua a){
	}
	public void visit(Trampa t){
	}
}