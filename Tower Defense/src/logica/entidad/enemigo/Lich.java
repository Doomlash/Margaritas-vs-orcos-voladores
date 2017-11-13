package logica.entidad.enemigo;

import logica.mapa.*;
import logica.premio.magiaTemporal.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Lich extends Enemigo{
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Lich(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=12;
		puntaje=70;
		monedas=15;
		vida=vidaMax=60;
		rango=1;
		fuerza=13;
		cargaAtaqueNecesaria = 30;
		cargaAtaqueActual = 20;
		duracionAtaque=7;
		grafico = new GraphicLich(x,y,map.getMapaGrafico());
		Escudo esc = new Escudo(m);
		m.getAlmacenHilos().getPowerUps().agregarPowerUp(esc);
		director.receive(esc);
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}