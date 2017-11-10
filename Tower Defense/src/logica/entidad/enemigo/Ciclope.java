package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import logica.disparo.disparoEnemigo.*;
import grafica.entidad.enemigo.*;

public class Ciclope extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Ciclope(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=8;
		puntaje=120;
		monedas=30;
		vida=vidaMax=70;
		rango=2;
		fuerza = 15;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		duracionAtaque=21;
		grafico = new GraphicCiclope(x,y,map.getMapaGrafico());
	}
	
	public void atacar(Obstaculo o){
			canMove=false;
			((GraphicEnemigo)grafico).atacar();
			map.getAlmacenHilos().getDisEnemigo().agregarDisparoEnemigo(new PiedraCiclope(x,y,map,x-rango,grafico.getPos().x-8,fuerza));
	}
}