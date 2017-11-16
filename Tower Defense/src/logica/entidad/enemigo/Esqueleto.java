package logica.entidad.enemigo;

import logica.mapa.*;
import grafica.entidad.enemigo.*;
import logica.gameObjects.*;

public class Esqueleto extends Enemigo{
	private Nigromante comandante;
	
	public Esqueleto(int x, int y, Mapa m, Nigromante n){
		super(x,y,1,1,m);
		this.comandante=n;
		velocidad=8;
		puntaje=5;
		monedas=0;
		vida=vidaMax=10;
		rango=1;
		fuerza=10;
		duracionAtaque=8;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicEsqueleto(x,y,map.getMapaGrafico());
	}
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}
	
	public void kill(){
		comandante.eliminarEsqueleto(this);
		super.kill();
	}
}