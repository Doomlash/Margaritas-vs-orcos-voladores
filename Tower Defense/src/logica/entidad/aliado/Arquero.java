package logica.entidad.aliado;

import logica.mapa.*;
import logica.gameObjects.*;
import logica.disparo.disparoAliado.*;
import logica.entidad.stateEscudo.*;
import grafica.entidad.aliado.*;

public class Arquero extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Arquero(int x,int y, Mapa m){
		super(x,y,1,m);
		precio = 50;
		vida=vidaMax=50;
		rango=2;
		fuerza=7;
		grafico = new GraphicArquero(x,y);
		Invulnerable i = new Invulnerable(this);
		Thread t = new Thread(i);
		t.start();
		this.escudo = i;
	}
	public void atacar(Obstaculo o){
		grafico.atacar();
		map.getAlmacenHilos().getDisAliado().agregarDisparoAliado(new Flecha(x+dimensionX,y,map,x+dimensionX+rango-1));
	}
}