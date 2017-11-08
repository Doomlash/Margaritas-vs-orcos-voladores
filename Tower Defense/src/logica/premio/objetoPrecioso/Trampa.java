package logica.premio.objetoPrecioso;

import logica.gameObjects.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.gameObjects.*;
import grafica.premio.*;

public class Trampa extends Obstaculo{
	private int damage;
	
	public Trampa(int x, int y, Mapa m){
		super(x,y,1,m);
		damage=3;
		grafico = new GraphicTrampa(x,y);
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public void kill(){
		map.eliminarElemento(this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}