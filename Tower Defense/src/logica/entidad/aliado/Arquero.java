package logica.entidad.aliado;

import logica.mapa.*;
import logica.premio.magiaTemporal.PowerBooster;
import logica.gameObjects.*;
import logica.disparo.disparoAliado.*;
import grafica.entidad.aliado.*;

public class Arquero extends Aliado{
	private int cd,cdTemporal;
	
	/**
	 * Se inicializa el objeto grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Indica la posicion inicial de columna dentro de la matriz del mapa.
	 * @param y : int - Indica la posicion de fila dentro de la matriz del mapa
	 * @param m : Mapa - Destinado a vincular el objeto con el mapa.
	 */
	public Arquero(int x,int y, Mapa m){
		super(x,y,1,m);
		precio = 100;
		vida=vidaMax=50;
		rango=6;
		fuerza=7;
		cd=100;
		cdTemporal=10;
		grafico = new GraphicArquero(x,y);
	}
	
	@Override
	public void atacarRango(){
		if(cdTemporal==0){
			cdTemporal=cd;
			for(int i=(x+dimensionX);i<x+dimensionX+rango;i++){
				Celda c = map.getCelda(i, y);
				if(c!=null){
					c.accept(visitorAtaque);
				}
			}
		}
		else{
			cdTemporal--;
		}
	}
	public void atacar(Obstaculo o){
		grafico.atacar();
		map.getAlmacenHilos().getDisAliado().agregarDisparoAliado(new Flecha(x+dimensionX,y,map,x+dimensionX+rango-1));
	}
	public void setCd(int newCd){
		cd=newCd;
	}
	public int getCd(){
		return cd;
	}
	public void boostear(){
		new PowerBooster(x,y,map).activar(this);
	}
	public void armadura(){
		vida+=30;
		fuerza+=3;
	
	}
}