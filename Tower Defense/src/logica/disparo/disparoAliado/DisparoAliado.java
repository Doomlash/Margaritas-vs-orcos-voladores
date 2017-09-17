package logica.disparo.disparoAliado;

import logica.disparo.*;

public class DisparoAliado extends Disparo{

	/**
	 * Invoca al move de la clase padre Disparo con la siguiente posicion en x a moverse
	 */
	public void move(){
		move(x[x.length-1]+1);
	}
}