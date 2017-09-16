package logica.gameObjects;

import logica.mapa.*;

public abstract class GameObject{
	protected int[] x;
	protected int y;
	protected Mapa map;
	
	public int[] getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}