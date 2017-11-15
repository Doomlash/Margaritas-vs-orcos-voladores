package logica.mapa.elementosMapa.temporales;

import logica.mapa.*;
import logica.visitor.*;
import logica.gameObjects.*;
import grafica.mapa.GraphicElementosMapa.GraphicTemporales.*;
import grafica.gameObjects.*;

public class Agua extends Elemento{
	private int tiempo=50;
	
	public Agua(int x,int y, Mapa m){
		super(x,y,1,1,m);
		grafico = new GraphicAgua(x,y);
	}
	public void decrementarTiempo(){
		tiempo--;
	}
	public int getTiempo(){
		return tiempo;
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