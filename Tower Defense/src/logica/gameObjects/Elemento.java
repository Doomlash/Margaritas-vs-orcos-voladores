package logica.gameObjects;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;

public abstract class Elemento extends GameObject{
	
	public abstract boolean accept(VisitorColision v);
	public abstract void accept(VisitorInteraccion v);
}