package logica.Visitor.VisitorInteraccion;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorAtaqueAliado extends VisitorInteraccion{
	protected  Aliado aliado;
	
	public VisitorAtaqueAliado(Aliado a){
		aliado=a;
	}

	public void visit(Aliado a){
	}
	public void visit(Enemigo e){
		e.setVida(e.getVida()-aliado.getFuerza());
	}
	public void visit(Barricada b){
	}
	public void visit(Piedra p){
		p.setVida(p.getVida()-aliado.getFuerza());
	}
	public void visit(Agua a){
	}
	public void visit(Trampa t){
	}
}
