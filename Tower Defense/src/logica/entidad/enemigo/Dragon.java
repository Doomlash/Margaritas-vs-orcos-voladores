package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Dragon extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Dragon(int x, int y, Mapa m){
		super(x,y,2,m);
		velocidad=4;
		puntaje=180;
		monedas=50;
		grafico = new GraphicDragon(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	/**
	 * Se determina la funcion del hilo
	 */
	public void run(){
		while(execute){
				try {
					move();
				} catch (InterruptedException e) {
				}
		}
	}
}