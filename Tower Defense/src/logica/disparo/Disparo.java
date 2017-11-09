package logica.disparo;

import logica.gameObjects.*;
import logica.mapa.Mapa;


public abstract class Disparo extends GameObject{
	protected int damage,velocidad,alcance;
	protected boolean canMove;

	public Disparo(int x,int y, Mapa m, int a, int dam){
		super(x,y,1,1,m);
		alcance = a;
		damage=dam;
		canMove=true;
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
	public abstract void ejecutar();
}