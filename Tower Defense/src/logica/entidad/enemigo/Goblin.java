package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Goblin extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Goblin(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=12;
		puntaje=50;
		monedas=5;
		vida=vidaMax=50;
		rango=1;
		fuerza=10;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		grafico = new GraphicGoblin(x,y,map.getMapaGrafico());
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
		map.getNivel().getJuego().getGui().getEnemigos()[2]=null;		
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		try{
			Thread.sleep(400);
		}catch(InterruptedException e){
		}
		o.setVida(o.getVida()-fuerza);
		canMove=true;
	}
}