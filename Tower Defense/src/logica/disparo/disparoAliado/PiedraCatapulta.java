package logica.disparo.disparoAliado;

import grafica.disparo.disparoAliado.*;
import logica.mapa.*;

public class PiedraCatapulta extends DisparoAliado{
	
	public PiedraCatapulta(int x, int y, Mapa m, int alcance, int dam){
		super(x,y,m,alcance,dam);
		velocidad=16;
		grafico = new GraphicPiedraCatapulta(x,y);
		map.getMapaGrafico().addGraphicElemento(getGraphic());
	}
}