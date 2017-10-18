package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Lich extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Lich(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=6;
		puntaje=70;
		monedas=15;
		grafico = new GraphicLich(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	
	public void atacar(Obstaculo o){
		
	}
}