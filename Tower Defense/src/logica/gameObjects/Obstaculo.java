package logica.gameObjects;

import logica.mapa.*;

public abstract class Obstaculo extends Elemento{
	protected int vida;
	protected int vidaMax;
	
	public Obstaculo(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	
	public void setVida(int v){
		if(v>vidaMax)
			vida=vidaMax;
		else
			if(v<=0)
				vida=0;
			else
				vida=v;
	}
	public int getVida(){
		return vida;
	}
}