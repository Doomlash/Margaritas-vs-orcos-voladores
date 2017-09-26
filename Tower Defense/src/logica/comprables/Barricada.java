package logica.comprables;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.mapa.*;
import logica.gameObjects.*;

public class Barricada extends Obstaculo implements Comprable{
	private int precio;

	public Barricada(int x,int y, Mapa m){
		super(x,y,1,m);
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public int getPrecio(){
		return precio;
	}
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
	
	public void kill(){
		map.eliminarElemento(x, y, this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
}