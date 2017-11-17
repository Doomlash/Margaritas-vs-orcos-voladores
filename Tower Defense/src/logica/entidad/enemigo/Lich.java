package logica.entidad.enemigo;

import logica.mapa.*;
import logica.premio.magiaTemporal.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Lich extends Enemigo{
	private boolean escudoGenerado=false;
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Lich(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=8;
		puntaje=100;
		monedas=150;
		vida=vidaMax=80;
		rango=1;
		fuerza=25;
		duracionAtaque=7;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicLich(x,y,map.getMapaGrafico());
	}
	public void move(){
		super.move();
		if(!escudoGenerado){
			escudoGenerado=true;
			Escudo esc = new Escudo(map);
			map.getAlmacenHilos().getPowerUps().agregarPowerUp(esc);
			director.receive(esc);
		}
	}
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}