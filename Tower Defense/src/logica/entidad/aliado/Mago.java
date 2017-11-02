package logica.entidad.aliado;

import logica.mapa.*;
import logica.disparo.disparoAliado.*;
import logica.gameObjects.*;
import grafica.entidad.aliado.*;

public class Mago extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Mago(int x, int y, Mapa m){
		super(x,y,1,m);
		precio = 80;
		vida=vidaMax=30;
		rango=3;
		fuerza=3;
		grafico = new GraphicMago(x,y);
	}
	public void atacar(Obstaculo o){
		grafico.atacar();
		map.getAlmacenHilos().getDisAliado().agregarDisparoAliado(new ProyectilMagico(x+dimensionX,y,map,x+dimensionX+rango-1));
	}
}