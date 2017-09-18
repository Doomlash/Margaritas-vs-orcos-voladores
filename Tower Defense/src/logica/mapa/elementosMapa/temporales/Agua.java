package logica.mapa.elementosMapa.temporales;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.mapa.*;
import logica.gameObjects.*;
import grafica.mapa.GraphicElementosMapa.GraphicTemporales.*;

public class Agua extends Elemento{

	public Agua(int x,int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicAgua(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}