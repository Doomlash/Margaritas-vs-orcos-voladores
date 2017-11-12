package logica.entidad.aliado;

import logica.mapa.Mapa;
import logica.gameObjects.*;
import grafica.entidad.aliado.*;

public class Swordman extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Swordman(int x, int y, Mapa m){
		super(x,y,1,1,m);
		precio = 50;
		vida=vidaMax=90;
		rango=1;
		fuerza=14;
		duracionAtaque=7;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicSwordman(x,y,map.getMapaGrafico());
	}
	public void atacar(Obstaculo o){
		((GraphicAliado)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}