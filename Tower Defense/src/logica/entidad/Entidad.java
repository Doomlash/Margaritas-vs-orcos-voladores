package logica.entidad;

import logica.gameObjects.*;
import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;

public abstract class Entidad extends Obstaculo{
	protected VisitorColision visitorColision;
	protected VisitorInteraccion visitorAtaque;
	protected int rango,fuerza,fuerzaActual;
	
	public void setFuerza(int f){
		fuerzaActual=f;
	}
	
	public int getFuerza(){
		return fuerzaActual;
	}
}
