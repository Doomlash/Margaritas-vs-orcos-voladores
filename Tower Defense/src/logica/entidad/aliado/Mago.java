package logica.entidad.aliado;

import grafica.entidad.aliado.*;
import logica.mapa.*;

public class Mago extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Mago(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicMago(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
}