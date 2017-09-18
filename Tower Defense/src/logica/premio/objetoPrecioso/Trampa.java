package logica.premio.objetoPrecioso;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.gameObjects.*;
import logica.mapa.*;

public class Trampa extends Obstaculo{
	
	public Trampa(int x, int y, Mapa m){
		super(x,y,1,m);
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}