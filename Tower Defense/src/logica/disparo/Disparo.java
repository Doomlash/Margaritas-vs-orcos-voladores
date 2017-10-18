package logica.disparo;

import logica.gameObjects.*;
import logica.mapa.Mapa;


public abstract class Disparo extends GameObject{
	protected int damage,velocidad,alcance;
	

	public Disparo(int x,int y, Mapa m, int a){
		super(x,y,1,m);
		alcance = a;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	public int getDamage(){
		return damage;
	}
}