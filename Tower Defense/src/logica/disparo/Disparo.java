package logica.disparo;

import logica.gameObjects.*;
import logica.Visitor.VisitorColisiones.*;
import java.util.List;


public abstract class Disparo extends GameObject{
	protected VisitorColision visitor;
	protected int da�o,velocidad,impactos;
	
	public abstract void move();
	public void move(int nextX){
		List<Elemento> list= map.getCelda(nextX, y).getElementos();
		boolean hayColision=false;
		int pos=0;
		if(!list.isEmpty()){
			while(!hayColision&&(pos<list.size())){
				hayColision= list.get(pos).accept(visitor);
				pos++;
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
	public int getDa�o(){
		return da�o;
	}
	public int getImpactos(){
		return impactos;
	}
}