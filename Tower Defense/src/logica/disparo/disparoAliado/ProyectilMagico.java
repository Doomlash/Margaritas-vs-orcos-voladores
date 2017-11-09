package logica.disparo.disparoAliado;

import logica.mapa.Mapa;
import grafica.disparo.disparoAliado.*;

public class ProyectilMagico extends DisparoAliado{
	
	public ProyectilMagico(int x, int y, Mapa m, int alcance, int dam){
		super(x,y,m,alcance,dam);
		velocidad=16;
		grafico = new GraphicProyectilMagico(x,y);
		map.getMapaGrafico().addGraphicElemento(getGraphic());
	}
}