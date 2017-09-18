package logica.gameObjects;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.mapa.*;

public abstract class Elemento extends GameObject{
	
	public Elemento(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	
	public abstract boolean accept(VisitorColision v);
	public abstract void accept(VisitorInteraccion v);
}