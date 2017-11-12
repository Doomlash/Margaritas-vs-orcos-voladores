package logica.entidad.enemigo;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.entidad.enemigo.*;

public class Cerberus extends Enemigo{
	private boolean atacando=false;
	
	public Cerberus(int x, int y, Mapa m){
		super(x,y,2,3,m);
		velocidad=12;
		puntaje=50;
		monedas=5;
		vida=vidaMax=200;
		rango=1;
		fuerza=40;
		cargaAtaqueNecesaria = 30;
		cargaAtaqueActual = 20;
		duracionAtaque=10;
		grafico = new GraphicCerberus(x,y,map.getMapaGrafico());		
	}
	
	public void atacarRango(){
		super.atacarRango();
		if(duracionAtaque==cargaAtaqueActual)
			atacando=false;
	}
	public void atacar(Obstaculo o){
		if(!atacando){
			canMove=false;
			((GraphicCerberus)grafico).atacar((o.getY()+o.getDimensionY()-1)-y);
			o.setVida(o.getVida()-fuerza);
			atacando=true;
		}
	}
}