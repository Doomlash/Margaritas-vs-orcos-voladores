package logica.gameObjects;

import logica.mapa.*;
import grafica.gameObjects.*;

public abstract class Obstaculo extends Elemento{
	protected int vida;
	protected int vidaMax;
	
	public Obstaculo(int x, int y, int dx, int dy, Mapa m){
		super(x,y,dx,dy,m);
	}
	
	/**
	 * Modifica la vida del elemento con el parametro v. Si se sobrepasa la vida máxima del 
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
		((GraphicObstaculo)grafico).actualizarLifeLine(vidaMax, vida);
	}
	public int getVida(){
		return vida;
	}
	public void setVidaMax(int v){
		vidaMax=v;
	}
	public int getVidaMax(){
		return vidaMax;
	}
}