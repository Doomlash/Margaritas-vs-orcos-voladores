package logica.disparo;

import logica.gameObjects.*;
import logica.mapa.Mapa;


public abstract class Disparo extends GameObject{
	protected int damage,velocidad,impactos;
	

	public Disparo(int x,int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	public void setImpactos(int i){
		if(i<=0){
			impactos=0;
			kill();
		}
		else
			impactos=i;
	}
	public void kill(){
		
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	public int getDamage(){
		return damage;
	}
	public int getImpactos(){
		return impactos;
	}
}