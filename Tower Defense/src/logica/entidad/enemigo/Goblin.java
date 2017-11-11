package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import grafica.entidad.enemigo.*;

public class Goblin extends Enemigo{
	
	public Goblin(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=12;
		puntaje=50;
		monedas=5;
		vida=vidaMax=50;
		rango=1;
		fuerza=10;
		cargaAtaqueNecesaria = 30;
		cargaAtaqueActual = 20;
		duracionAtaque=6;
		grafico = new GraphicGoblin(x,y,map.getMapaGrafico());
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
}