package logica.entidad.enemigo;

import logica.mapa.*;
import grafica.entidad.enemigo.*;
import logica.gameObjects.*;

public class Esqueleto extends Enemigo{
	private Nigromante comandante;
	
	public Esqueleto(int x, int y, Mapa m, Nigromante n){
		super(x,y,1,1,m);
		this.comandante=n;
		velocidad=12;
		puntaje=50;
		monedas=5;
		vida=vidaMax=50;
		rango=1;
		fuerza=10;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		grafico = new GraphicEsqueleto(x,y,map.getMapaGrafico());
	}
	public void SACARDEARREGLO(){
		
	}
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
		canMove=true;
	}
	
	public void kill(){
		comandante.eliminarEsqueleto(this);
		super.kill();
	}
}