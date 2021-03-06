package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Ogro extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Ogro(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=5;
		puntaje=50;
		monedas=50;
		vida=vidaMax=100;
		rango=1;
		fuerza=50;
		duracionAtaque=6;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicOgro(x,y,map.getMapaGrafico());
	}

	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}