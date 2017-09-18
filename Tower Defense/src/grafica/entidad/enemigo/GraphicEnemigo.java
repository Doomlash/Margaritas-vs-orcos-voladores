package grafica.entidad.enemigo;

import grafica.gameObjects.*;

public abstract class GraphicEnemigo extends GraphicGameObject{
	protected int velocidad;
	
	public GraphicEnemigo(int x, int y, int velocidad){
		super(x,y);
	}
	public void move(){
		pos.setLocation(pos.x-velocidad, pos.y);
	}
	public void setVelocidad(int v){
		velocidad=v;
	}
}