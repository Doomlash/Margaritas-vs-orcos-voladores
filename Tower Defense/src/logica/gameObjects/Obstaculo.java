package logica.gameObjects;

import logica.mapa.*;

public abstract class Obstaculo extends Elemento{
	protected int vida;
	protected int vidaMax;
	
	public Obstaculo(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	
	/**
	 * Modifica la vida del elemento con el parametro v. Si se sobrepasa la vida m�xima del 
	 * obstaculo se le asigna a vida la vida maxima posible del mismo. En caso de que la vida 
	 * sea inferior o igual a 0 se le asigna a vida 0.
	 * @param v
	 */
	public void setVida(int v){
		if(v>vidaMax)
			vida=vidaMax;
		else
			if(v<=0){
				vida=0;
				kill();
			}
			else
				vida=v;
	}
	public int getVida(){
		return vida;
	}
}