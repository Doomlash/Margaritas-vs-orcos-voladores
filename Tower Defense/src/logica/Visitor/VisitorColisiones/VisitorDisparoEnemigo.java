package logica.Visitor.VisitorColisiones;

import logica.comprables.Barricada;
import logica.disparo.disparoEnemigo.*;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorDisparoEnemigo {
	private DisparoEnemigo d;
	
	public boolean visit(Aliado a){
		if(a.getCP()!=null){
			a.getCP().destroy();
		}
		else{
			a.setVida(a.getVida()-d.getDaño());
		}
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	public boolean visit(Enemigo e){
		return false;
	}
	public boolean visit(Barricada b){
		b.setVida(b.getVida()-d.getDaño());
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	public boolean visit(Piedra p){
		p.setVida(p.getVida()-d.getDaño());
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