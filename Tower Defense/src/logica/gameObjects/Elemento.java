package logica.gameObjects;

import logica.mapa.*;
import logica.visitor.*;

public abstract class Elemento extends GameObject{
	
	public Elemento(int x, int y, int dx, int dy, Mapa m){
		super(x,y,dx,dy,m);
	}
	
	public abstract void accept(Visitor v);
}