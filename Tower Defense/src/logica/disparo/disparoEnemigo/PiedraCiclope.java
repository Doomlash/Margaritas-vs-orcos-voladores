package logica.disparo.disparoEnemigo;

import grafica.disparo.disparoEnemigo.*;
import logica.mapa.*;

public class PiedraCiclope extends DisparoEnemigo{
	
	public PiedraCiclope(int x, int y, Mapa m, int alcance, int gx, int dam, int generacion){
		super(x,y,m,alcance,dam,generacion,2);
		velocidad=14;
		grafico = new GraphicPiedraCiclope(x,y);
		grafico.cambiarPos(gx, grafico.getPos().y-15);
	}
}