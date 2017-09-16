package logica.comprables;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.gameObjects.*;

public class Barricada extends Obstaculo implements Comprable{
	private int precio;
	
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public int getPrecio(){
		return precio;
	}
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}