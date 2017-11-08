package logica.entidad.aliado;

import logica.mapa.*;
import logica.gameObjects.*;
import grafica.entidad.aliado.*;

public class Monje extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Monje(int x, int y, Mapa m){
		super(x,y,1,1,m);
		grafico = new GraphicMonje(x,y,map.getMapaGrafico());
	}
	public void atacar(Obstaculo o){
		
	}
}