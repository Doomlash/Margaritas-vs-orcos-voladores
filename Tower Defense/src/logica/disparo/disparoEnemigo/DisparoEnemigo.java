package logica.disparo.disparoEnemigo;

import logica.disparo.*;
import logica.mapa.*;

public abstract class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int x,int y, Mapa m){
		super(x,y,1,m);
	}
	/**
	 * Invoca al move de la clase padre Disparo con la siguiente posicion en x a moverse
	 */
}