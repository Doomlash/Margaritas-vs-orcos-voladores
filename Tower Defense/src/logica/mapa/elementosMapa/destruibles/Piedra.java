package logica.mapa.elementosMapa.destruibles;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.gameObjects.*;
import grafica.mapa.GraphicElementosMapa.GraphicDestruibles.*;

public class Piedra extends Obstaculo{
	
	public Piedra(int x[], int y){
		this.x=x;
		this.y=y;
		grafico = new GraphicPiedra(x[0],y);
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}