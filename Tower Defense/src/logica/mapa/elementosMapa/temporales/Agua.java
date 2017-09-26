package logica.mapa.elementosMapa.temporales;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.mapa.*;
import logica.gameObjects.*;
import grafica.mapa.GraphicElementosMapa.GraphicTemporales.*;

public class Agua extends Elemento implements Runnable{
	
	public Agua(int x,int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicAgua(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	
	public void run(){
		try{
			Thread.sleep(15000);
		}catch(InterruptedException e){
		}
		kill();
	}
	
	public void accept(VisitorInteraccion v){
		v.visit(this);
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