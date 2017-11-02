package logica.entidad.enemigo;

import logica.mapa.*;
import logica.entidad.stateEscudo.Invulnerable;
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
		super(x,y,1,m);
		velocidad=vm=12;
		puntaje=70;
		monedas=15;
		vida=vidaMax=60;
		rango=1;
		fuerza=13;
		grafico = new GraphicLich(x,y,map.getMapaGrafico());
		Invulnerable i = new Invulnerable(this);
		Thread t = new Thread(i);
		t.start();
		this.escudo = i;
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
		map.getNivel().getJuego().getGui().getEnemigos()[3]=null;		
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		grafico.atacar();
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
		}
		o.setVida(o.getVida()-fuerza);
		grafico.avanzar();
		canMove=true;
	}
}