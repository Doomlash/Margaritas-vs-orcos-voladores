package logica.gameObjects;

import logica.mapa.*;
import grafica.gameObjects.*;

public abstract class GameObject{
	protected int[] x;
	protected int y;
	protected Mapa map;
	protected GraphicGameObject grafico;
	
	public int[] getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}