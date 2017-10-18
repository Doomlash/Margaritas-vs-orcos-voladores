package logica.mapa.elementosMapa.destruibles;

import logica.gameObjects.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.mapa.GraphicElementosMapa.GraphicDestruibles.*;
import grafica.gameObjects.*;

public class Piedra extends Obstaculo{
	private GraphicPiedra grafico;
	
	public Piedra(int x, int y, Mapa m){
		super(x,y,1,m);
		vida=vidaMax=75;
		grafico = new GraphicPiedra(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
	public void kill(){
		map.eliminarElemento(this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
}