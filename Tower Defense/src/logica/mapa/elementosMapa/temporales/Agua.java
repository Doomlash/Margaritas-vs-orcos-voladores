package logica.mapa.elementosMapa.temporales;

import logica.mapa.*;
import logica.visitor.*;
import logica.gameObjects.*;
import grafica.mapa.GraphicElementosMapa.GraphicTemporales.*;
import grafica.gameObjects.*;

public class Agua extends Elemento implements Runnable{
	private GraphicAgua grafico;
	
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
	
	public void accept(Visitor v){
		v.visit(this);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
	public void kill(){
		map.eliminarElemento(this);
	}
}