package logica.mapa.elementosMapa.destruibles;

import logica.gameObjects.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.mapa.GraphicElementosMapa.GraphicDestruibles.*;
import grafica.gameObjects.*;

public class Piedra extends Obstaculo{
	
	public Piedra(int x, int y, Mapa m){
		super(x,y,1,1,m);
		vida=vidaMax=75;
		grafico = new GraphicPiedra(x,y,m.getMapaGrafico());
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
	public void kill(){
		((GraphicObstaculo)grafico).removeLifeLine();
		map.eliminarElemento(this);
	}
}