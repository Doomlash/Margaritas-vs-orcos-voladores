package logica.disparo.disparoAliado;

import logica.mapa.*;
import grafica.disparo.disparoAliado.*;

public class Flecha extends DisparoAliado{
	
	public Flecha(int x, int y, Mapa m, int alcance){
		super(x,y,m,alcance);
		velocidad=16;
		damage = 7;
		grafico = new GraphicFlecha(x,y);
		map.getMapaGrafico().addGraphicElemento(getGraphic());
	}
}