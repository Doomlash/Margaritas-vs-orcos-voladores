package logica.disparo;

import logica.gameObjects.*;
import logica.mapa.Mapa;
import logica.Visitor.VisitorColisiones.*;


public abstract class Disparo extends GameObject{
	protected VisitorColision visitor;
	protected int damage,velocidad,impactos;
	

	public Disparo(int x,int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	public abstract void move();
	public void move(int nextX){
		Iterable<Elemento> list= map.getCelda(nextX, y).getElementos();
		boolean hayColision=false;
		for(Elemento e : list){
			if(!hayColision){
				hayColision = e.accept(visitor);
			}
		}
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