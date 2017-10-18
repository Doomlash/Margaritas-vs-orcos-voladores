package logica.entidad.aliado;

import logica.mapa.Mapa;
import logica.disparo.disparoAliado.*;
import logica.gameObjects.*;
import grafica.entidad.aliado.*;

public class Catapulta extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Catapulta(int x, int y, Mapa m){
		super(x,y,2,m);
		grafico = new GraphicCatapulta(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void atacar(Obstaculo o){
		new PiedraCatapulta(x,y,map,x+dimensionX+rango);
	}
}