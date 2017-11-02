package logica.entidad.aliado;

import logica.mapa.Mapa;
import logica.disparo.disparoAliado.*;
import logica.gameObjects.*;
import grafica.entidad.aliado.*;

public class Catapulta extends Aliado{
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Catapulta(int x, int y, Mapa m){
		super(x,y,2,m);
		precio = 100;
		vida=vidaMax=70;
		rango=3;
		fuerza=9;
		grafico = new GraphicCatapulta(x,y);
	}
	public void atacar(Obstaculo o){
		grafico.atacar();
		map.getAlmacenHilos().getDisAliado().agregarDisparoAliado(new PiedraCatapulta(x+dimensionX,y,map,x+dimensionX+rango));
		((GraphicCatapulta)grafico).finalizarAtaque();
	}
	@Override
	public void boostear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCd(int newCd) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getCd() {
		// TODO Auto-generated method stub
		return 0;
	}
}