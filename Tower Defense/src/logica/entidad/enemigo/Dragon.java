package logica.entidad.enemigo;

import logica.mapa.*;
import logica.disparo.disparoEnemigo.*;
import logica.gameObjects.*;
import logica.visitor.*;
import grafica.entidad.enemigo.*;

public class Dragon extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Dragon(int x, int y, Mapa m){
		super(x,y,2,1,m);
		velocidad=8;
		puntaje=180;
		monedas=50;
		vida=vidaMax=120;
		rango=3;
		fuerza = 10;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		grafico = new GraphicDragon(x,y,map.getMapaGrafico());
		visitorMovimiento = new VisitorMovimientoDragon(this,m);
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
		map.getNivel().getJuego().getGui().getEnemigos()[1]=null;		
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicDragon)grafico).aterrizar();
		((GraphicEnemigo)grafico).atacar();
		try{
			Thread.sleep(400);
		}catch(InterruptedException e){
		}
		map.getAlmacenHilos().getDisEnemigo().agregarDisparoEnemigo(new BolaDeFuego(x,y,map,x-rango,grafico.getPos().x-5));
		((GraphicDragon)grafico).despegar();
		canMove=true;
	}
}