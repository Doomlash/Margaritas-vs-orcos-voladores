package logica.mapa.elementosMapa.destruibles;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.gameObjects.*;
import logica.mapa.*;
import grafica.mapa.GraphicElementosMapa.GraphicDestruibles.*;

public class Piedra extends Obstaculo{
	
	public Piedra(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicPiedra(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}