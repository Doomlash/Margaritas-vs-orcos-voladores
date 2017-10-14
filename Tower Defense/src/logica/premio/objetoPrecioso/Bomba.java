package logica.premio.objetoPrecioso;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.gameObjects.*;
import grafica.premio.*;

public class Bomba extends GameObject{
	private GraphicBomba grafico;
	
	public Bomba(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicBomba(x,y);
	}
	
	public void kill(){
		
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}