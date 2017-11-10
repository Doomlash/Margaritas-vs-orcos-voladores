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
		super(x,y,2,1,m);
		precio = 100;
		vida=vidaMax=70;
		rango=3;
		fuerza=15;
		duracionAtaque=13;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicCatapulta(x,y,map.getMapaGrafico());
	}
	public void atacar(Obstaculo o){
		((GraphicAliado)grafico).atacar();
		map.getAlmacenHilos().getDisAliado().agregarDisparoAliado(new PiedraCatapulta(x+dimensionX,y,map,x+dimensionX+rango,fuerza));
	}
}