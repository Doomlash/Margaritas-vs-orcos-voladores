package logica.disparo.disparoEnemigo;

import logica.disparo.*;

public class DisparoEnemigo extends Disparo{
	
	/**
	 * Invoca al move de la clase padre Disparo con la siguiente posicion en x a moverse
	 */
	public void move(){
		move(x[0]-1);
	}
}