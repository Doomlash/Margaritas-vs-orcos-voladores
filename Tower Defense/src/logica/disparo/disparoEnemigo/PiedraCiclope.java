package logica.disparo.disparoEnemigo;

import grafica.disparo.disparoEnemigo.*;
import logica.mapa.*;

public class PiedraCiclope extends DisparoEnemigo{
	
	public PiedraCiclope(int x, int y, Mapa m, int alcance, int gx){
		super(x,y,m,alcance);
		velocidad=16;
		damage = 15;
		grafico = new GraphicPiedraCiclope(x,y);
		grafico.getGrafico();
		grafico.cambiarPos(gx, grafico.getPos().y-15);
		map.getMapaGrafico().addGraphicElemento(grafico);
	}
}