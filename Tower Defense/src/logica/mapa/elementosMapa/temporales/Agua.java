package logica.mapa.elementosMapa.temporales;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.gameObjects.*;
import grafica.mapa.GraphicElementosMapa.GraphicTemporales.*;

public class Agua extends Elemento{
	
	public Agua(int x[], int y){
		this.x=x;
		this.y=y;
		grafico = new GraphicAgua(x[0],y);
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}