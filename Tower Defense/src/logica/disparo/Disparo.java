package logica.disparo;

import logica.gameObjects.*;
import logica.mapa.Mapa;


public abstract class Disparo extends GameObject{
	protected int damage,velocidad,alcance,tiempoGeneracion;
	protected int cantImpactos;
	protected boolean canMove;

	public Disparo(int x,int y, Mapa m, int a, int dam, int generacion, int cantImp){
		super(x,y,1,1,m);
		alcance = a;
		damage=dam;
		canMove=true;
		tiempoGeneracion=generacion;
		cantImpactos=cantImp;
	}
	public void stop(){
		canMove=false;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	public int getDamage(){
		return damage;
	}
	public void impactar(){
		cantImpactos--;
	}
	public int getImpactos(){
		return cantImpactos;
	}
	public void recudirTiempoGeneracion(){
		tiempoGeneracion--;
		if(tiempoGeneracion==0)
			map.getMapaGrafico().addGraphicElemento(getGraphic());
	}
	public int getTiempoGeneracion(){
		return tiempoGeneracion;
	}
	public abstract void ejecutar();
}