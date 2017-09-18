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
	
	/**
	 * @param a : Aliado
	 * @return boolean - FALSE indicando que DisparoAliado no colisionó con Aliado
	 */
	public boolean visit(Aliado a){
		return false;
	}
	
	/**
	 * @param e : Enemigo
	 * Relaciona el DisparoAliado con un enemigo e modificando ambos objetos.
	 * @return boolean - TRUE que indica que DisparoAliado colisiona con el tipo Enemigo.
	 */
	public boolean visit(Enemigo e){
		if(e.getCP()!=null){
			e.getCP().destroy();
		}
		else{
			e.setVida(e.getVida()-d.getDamage());
		}
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	
	/**
	 * @param b : Barricada
	 * @return boolean - FALSE indicando que DisparoAliado no colisiona con el tipo Barricada.
	 */
	public boolean visit(Barricada b){
		return false;
	}
	
	/**
	 * @param p : Piedra
	 * Relaciona a DisparoAliado con Piedra y modifica a ambos objetos.
	 * @return boolean - TRUE indicando que DisparoAliado colisiona con el tipo Piedra.
	 */
	public boolean visit(Piedra p){
		p.setVida(p.getVida()-d.getDamage());
		d.setImpactos(d.getImpactos()-1);
		return true;
	}
	
	/**
	 * @param a : Agua
	 * @return boolean - FALSE indicando que DisparoAliado no colisiona con el tipo Agua.
	 */
	public boolean visit(Agua a){
		return false;
	}
	
	/**
	 * @param t : Trampa
	 * @return boolean - FALSE indicando que DisparoAliado no colisiona con el tipo Trampa
	 */
	public boolean visit(Trampa t){
		return false;
	}
}