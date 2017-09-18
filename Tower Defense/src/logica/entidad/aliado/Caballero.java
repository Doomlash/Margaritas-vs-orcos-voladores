package logica.entidad.aliado;

import logica.mapa.Mapa;
import grafica.entidad.aliado.*;

public class Caballero extends Aliado{

	public Caballero(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicCaballero(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
}