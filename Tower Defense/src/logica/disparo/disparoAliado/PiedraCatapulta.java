package logica.disparo.disparoAliado;

import grafica.disparo.disparoAliado.*;
import logica.mapa.*;

public class PiedraCatapulta extends DisparoAliado{
	
	public PiedraCatapulta(int x, int y, Mapa m, int alcance){
		super(x,y,m,alcance);
		velocidad=16;
		damage = 7;
		grafico = new GraphicPiedraCatapulta(x,y);
		map.getMapaGrafico().addGraphicElemento(getGraphic());
	}
}