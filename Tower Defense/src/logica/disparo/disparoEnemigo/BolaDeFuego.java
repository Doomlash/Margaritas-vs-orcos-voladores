package logica.disparo.disparoEnemigo;

import logica.mapa.Mapa;
import grafica.disparo.disparoEnemigo.*;

public class BolaDeFuego extends DisparoEnemigo{
	
	public BolaDeFuego(int x, int y, Mapa m, int alcance, int gx, int dam){
		super(x,y,m,alcance,dam);
		velocidad=16;
		grafico = new GraphicBolaDeFuego(x,y);
		grafico.getGrafico();
		grafico.cambiarPos(gx, grafico.getPos().y-15);
		map.getMapaGrafico().addGraphicElemento(grafico);
	}
}