package logica.entidad.enemigo;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.entidad.enemigo.*;

public class Cerberus extends Enemigo{
	
	public Cerberus(int x, int y, Mapa m){
		super(x,y,2,3,m);
		velocidad=12;
		puntaje=50;
		monedas=5;
		vida=vidaMax=200;
		rango=1;
		fuerza=40;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		duracionAtaque=24;
		grafico = new GraphicCerberus(x,y,map.getMapaGrafico());		
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}