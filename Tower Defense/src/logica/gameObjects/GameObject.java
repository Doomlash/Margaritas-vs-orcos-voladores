package logica.gameObjects;

import logica.mapa.*;
import grafica.gameObjects.*;

public abstract class GameObject{
	protected int x, y, dimensionX;
	protected Mapa map;
	protected GraphicGameObject grafico;
	
	/**
	 * Se inicializa la columna inicial dentro de la matriz del mapa con x, la fila con y, se 
	 * vincula el mapa a la clase y se determina el ancho del objeto con dx.
	 * @param x : int - Columna inicial
	 * @param y : int - Fila
	 * @param dx : int - Ancho del objeto
	 * @param m : Mapa - Mapa al cual el objeto pertenece.
	 */
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
	
	/**
	 * Retorna el elemento grafico asociado a la clase.
	 * @return GraphicGameObject
	 */
	public GraphicGameObject getGraphic(){
		return grafico;
	}
	public abstract void kill();
}