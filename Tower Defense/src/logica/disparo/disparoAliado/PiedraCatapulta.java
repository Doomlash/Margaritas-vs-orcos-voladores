package logica.disparo.disparoAliado;

import logica.mapa.*;
import grafica.disparo.disparoAliado.*;
import grafica.gameObjects.*;

public class PiedraCatapulta extends DisparoAliado{
	private GraphicPiedraCatapulta grafico;
	
	public PiedraCatapulta(int x, int y, Mapa m){
		super(x,y,m);
		grafico = new GraphicPiedraCatapulta(x,y);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}