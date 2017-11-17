package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Goblin extends Enemigo{
	
	public Goblin(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=10;
		puntaje=10;
		monedas=25;
		vida=vidaMax=80;
		rango=1;
		fuerza=25;
		duracionAtaque=6;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicGoblin(x,y,map.getMapaGrafico());
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}