package logica.gameObjects;

import logica.mapa.*;
import grafica.gameObjects.*;

public abstract class GameObject{
	protected int x, y, dimensionX;
	protected Mapa map;
	protected GraphicGameObject grafico;
	
	public GameObject(int x, int y, int dx, Mapa m){
		map=m;
		this.x=x;
		this.y=y;
		dimensionX=dx;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getDimensionX(){
		return dimensionX;
	}
	
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}