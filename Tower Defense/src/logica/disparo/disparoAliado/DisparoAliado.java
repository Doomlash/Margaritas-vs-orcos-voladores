package logica.disparo.disparoAliado;

import logica.disparo.*;
import logica.mapa.*;

public class DisparoAliado extends Disparo{

	public DisparoAliado(int x,int y, Mapa m){
		super(x,y,1,m);
	}
	/**
	 * Invoca al move de la clase padre Disparo con la siguiente posicion en x a moverse
	 */
	public void move(){
		move(x+1);
	}
}