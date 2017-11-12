package logica.disparo.disparoAliado;

import grafica.disparo.disparoAliado.*;
import logica.mapa.*;

public class PiedraCatapulta extends DisparoAliado{
	
	public PiedraCatapulta(int x, int y, Mapa m, int alcance, int dam, int generacion){
		super(x,y,m,alcance,dam,generacion);
		velocidad=16;
		grafico = new GraphicPiedraCatapulta(x,y);
	}
}