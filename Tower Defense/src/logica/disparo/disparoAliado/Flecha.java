package logica.disparo.disparoAliado;

import logica.mapa.*;
import grafica.disparo.disparoAliado.*;
import grafica.gameObjects.*;

public class Flecha extends DisparoAliado{
	private GraphicFlecha grafico;
	
	public Flecha(int x, int y, Mapa m){
		super(x,y,m);
		grafico = new GraphicFlecha(x,y);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}