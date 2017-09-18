package logica.Visitor.VisitorColisiones;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;
import logica.disparo.disparoAliado.*;

public class VisitorDisparoAliado extends VisitorColision{
	private DisparoAliado d;
	
	public boolean visit(Aliado a){
		return false;
	}
	public boolean visit(Enemigo e){
		if(e.getCP()!=null){
			e.getCP().destroy();
		}
		else{
			e.setVida(e.getVida()-d.getDanio());
		}
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	public boolean visit(Barricada b){
		return false;
	}
	public boolean visit(Piedra p){
		p.setVida(p.getVida()-d.getDanio());
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	public boolean visit(Agua a){
		return false;
	}
	public boolean visit(Trampa t){
		return false;
	}
}