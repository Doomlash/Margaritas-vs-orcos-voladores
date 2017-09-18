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
	
	/**
	 * Relaciona DisparoEnemigo con Aliado modificando ambos objetos.
	 * @param a : Aliado
	 * @return boolean - TRUE indicando que DisparoEnemigo colisiona con el tipo Aliado.
	 */
	public boolean visit(Aliado a){
		if(a.getCP()!=null){
			a.getCP().destroy();
		}
		else{
			a.setVida(a.getVida()-d.getDamage());
		}
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	
	/**
	 * 
	 * @param e : Enemigo
	 * @return boolean - FALSE indicando que DisparoEnemigo no colisiona con el tipo Enemigo.
	 */
	public boolean visit(Enemigo e){
		return false;
	}
	
	/**
	 * Relaciona DisparoEnemigo con Barricada modificando ambos objetos.
	 * @param b : Barricada
	 * @return boolean - TRUE indicando que DisparoEnemigo colisiona con el tipo Barricada.
	 */
	public boolean visit(Barricada b){
		b.setVida(b.getVida()-d.getDamage());
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	
	/**
	 * Relaciona DisparoEnemigo con Piedra modificando ambos objetos.
	 * @param p : Piedra
	 * @return boolean - TRUE indicando que DisparoEnemigo colisiona con el tipo Piedra.
	 */
	public boolean visit(Piedra p){
		p.setVida(p.getVida()-d.getDamage());
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	
	/**
	 * 
	 * @param a : Agua
	 * @return boolean - FALSE indicando que DisparoEnemigo no colisiona con el tipo Agua.
	 */
	public boolean visit(Agua a){
		return false;
	}
	
	/**
	 * 
	 * @param t : Trampa
	 * @return boolean - FALSE indicando que DisparoEnemigo no colisiona con el tipo Trampa.
	 */
	public boolean visit(Trampa t){
		return false;
	}
}