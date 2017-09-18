package logica.disparo;

import logica.gameObjects.*;
import logica.Visitor.VisitorColisiones.*;
import java.util.List;


public abstract class Disparo extends GameObject{
	protected VisitorColision visitor;
	protected int danio,velocidad,impactos;
	
	public abstract void move();
	public void move(int nextX){
		Iterable<Elemento> list= map.getCelda(nextX, y).getElementos();
//		List<Elemento> list= map.getCelda(nextX, y).getElementos();
		boolean hayColision=false;
		int pos=0;
		for(Elemento e : list){
			if(!hayColision){
				hayColision = e.accept(visitor);
			}
		}
		/*
		if(!list.isEmpty()){
			while(!hayColision&&(pos<list.size())){
				hayColision= list.get(pos).accept(visitor);
				pos++;
			}
		}*/
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
	public int getDanio(){
		return danio;
	}
	public int getImpactos(){
		return impactos;
	}
}