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
		super(x,y,1,m);
		velocidad=vm=6;
		puntaje=100;
		monedas=20;
		vida=vidaMax=80;
		rango=1;
		fuerza=25;
		grafico = new GraphicOgro(x,y);
	}
	/*ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	*/
	public void SACARDEARREGLO(){
		map.getNivel().getJuego().getGui().getEnemigos()[5]=null;		
	}

	public void atacar(Obstaculo o){
		canMove=false;
		grafico.atacar();
		try{
			Thread.sleep(400);
		}catch(InterruptedException e){
		}
		o.setVida(o.getVida()-fuerza);
		grafico.avanzar();
		canMove=true;
	}
}