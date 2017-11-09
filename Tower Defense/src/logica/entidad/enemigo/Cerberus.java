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
		vida=vidaMax=50;
		rango=1;
		fuerza=10;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		grafico = new GraphicCerberus(x,y,map.getMapaGrafico());		
	}
	
	public void SACARDEARREGLO(){
		map.getNivel().getJuego().getGui().getEnemigos()[6]=null;
	}
	
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
		canMove=true;		
	}
}