package logica.entidad.enemigo;

import logica.mapa.*;
import logica.disparo.disparoEnemigo.*;
import logica.gameObjects.*;
import logica.visitor.visitorEnemigo.*;
import grafica.entidad.enemigo.*;

public class Dragon extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Dragon(int x, int y, Mapa m){
		super(x,y,2,2,m);
		velocidad=8;
		puntaje=180;
		monedas=50;
		vida=vidaMax=120;
		rango=3;
		fuerza = 20;
		cargaAtaqueNecesaria = 25;
		cargaAtaqueActual = 20;
		duracionAtaque=11;
		grafico = new GraphicDragon(x,y,map.getMapaGrafico());
		visitorMovimiento = new VisitorMovimientoDragon(this,m);
	}
	public void atacarRango(){
		super.atacarRango();
		((GraphicDragon)grafico).resetearAtaques();
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		BolaDeFuego b = new BolaDeFuego(x,o.getY(),map,x-rango,grafico.getPos().x-60,fuerza,9);
		((GraphicDragon)grafico).atacar(o.getY(),o.getDimensionY(),y,b.getGraphic());
		map.getAlmacenHilos().getDisEnemigo().agregarDisparoEnemigo(b);
	}
}