package logica.premio.objetoPrecioso;

import logica.gameObjects.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.gameObjects.*;
import grafica.premio.*;

public class Trampa extends Elemento{
	private int damage=40;
	
	public Trampa(int x, int y, Mapa m){
		super(x,y,1,1,m);
		grafico = new GraphicTrampa(x,y,m.getMapaGrafico());
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	public int getDamage(){
		return damage;
	}
	
	public void kill(){
		map.eliminarElemento(this);
		map.getAlmacenHilos().getTrampasAccionar().agregarGrafico((GraphicTrampa)grafico);
		((GraphicTrampa)grafico).accionar();
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}