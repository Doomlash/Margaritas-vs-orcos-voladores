package logica.comprables;

import logica.mapa.*;
import logica.visitor.*;
import logica.gameObjects.*;
import grafica.gameObjects.*;
import grafica.comprables.*;

public class Barricada extends Obstaculo implements Comprable{
	private int precio;
	private GraphicBarricada grafico;

	public Barricada(int x,int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicBarricada(x,y);
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getPrecio(){
		return precio;
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