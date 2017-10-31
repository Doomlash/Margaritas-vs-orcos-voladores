package logica.disparo.disparoAliado;

import logica.mapa.Mapa;
import grafica.disparo.disparoAliado.*;

public class ProyectilMagico extends DisparoAliado{
	
	public ProyectilMagico(int x, int y, Mapa m, int alcance){
		super(x,y,m,alcance);
		velocidad=16;
		damage = 42;
		grafico = new GraphicProyectilMagico(x,y);
		map.getMapaGrafico().addGraphicElemento(getGraphic());
	}
}