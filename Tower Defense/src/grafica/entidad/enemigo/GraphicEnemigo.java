package grafica.entidad.enemigo;

import grafica.elemento.*;

public abstract class GraphicEnemigo extends GraphicElemento{
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