package logica.entidad.aliado;

import logica.mapa.*;
import logica.gameObjects.*;
import logica.disparo.disparoAliado.*;
import grafica.entidad.aliado.*;

public class Arquero extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Arquero(int x,int y, Mapa m){
		super(x,y,1,1,m);
		precio = 50;
		vida=vidaMax=50;
		rango=5;
		fuerza=7;
		cargaAtaqueNecesaria = 100;
		cargaAtaqueActual = 90;
		grafico = new GraphicArquero(x,y,map.getMapaGrafico());
	}
	public void atacar(Obstaculo o){
		((GraphicAliado)grafico).atacar();
		map.getAlmacenHilos().getDisAliado().agregarDisparoAliado(new Flecha(x+dimensionX,y,map,x+dimensionX+rango-1,fuerza));
	}
}