package logica.entidad.enemigo;

import logica.entidad.*;
import logica.gameObjects.Elemento;
import logica.mapa.*;

//import java.util.List;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;

public abstract class Enemigo extends Entidad implements Runnable{
	protected int velocidad;
	protected int puntaje;
	protected int monedas;
	protected volatile boolean execute;
	
	public Enemigo(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
		visitorColision = new VisitorColisionEnemigo();
		visitorAtaque = new VisitorAtaqueEnemigo(this);
		this.execute=true;
	}
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	public void terminate(){
		execute=false;
	}
	public void move() throws InterruptedException{
		if(x-1>=0){
			int aux= grafico.getPos().x-grafico.getWidth();
			System.out.println(aux);
			while(grafico.getPos().x>aux){
				grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y);
				Thread.sleep(500);
				grafico.getGrafico().repaint();
//				map.getNivel().getJuego().getGui().repaint();
			}
			map.getCelda(x-1, y).agregarElemento(this);
			map.getCelda(x, y).deleteElemento(this);
		}
	}
	
	public boolean canMove(){
		int nextX = x-1,pos=0;
		boolean hayColision=false;
		Iterable<Elemento> list = map.getCelda(nextX, y).getElementos();
		if(nextX>=0){
			if(map.getCelda(nextX, y).isEmpty()){
				hayColision=true;
			}
			for(Elemento e : list){
				if(!hayColision){
					hayColision = e.accept(visitorColision);
				}
			}
		}
		return hayColision;
//		List<Elemento> list = map.getCelda(nextX, y).getElementos();
//		if(nextX>=0){
//			if(!list.isEmpty()){
//				while(pos<list.size()&&!hayColision){
//					hayColision = list.get(pos).accept(visitorColision);
//					pos++;
//				}
//			}
//			else
//				hayColision=true;
//		}
//		return hayColision;
	}
	
	public Elemento chequearColision(int k, int f){
		Iterable<Elemento> list = null;
		boolean hayColision= false;
		for(int i=k;(i<=f)&&(!hayColision);i++){
			list=map.getCelda(i, this.y).getElementos();
			for(Elemento e : list){
				if(!hayColision){
					hayColision = e.accept(visitorColision);
					return e;
				}
			}
		}
		return null;
		/*
		List<Elemento> list = null;
		Elemento ele;
		int pos=0;
		boolean hayColision= false;
		for(int i=k;(i>=f)&&(!hayColision);i--){
			list=map.getCelda(i, y).getElementos();
			if(!list.isEmpty()){
				ele=list.get(pos);
				while((pos<list.size())&&(!hayColision)){
					hayColision= ele.accept(visitorColision);
					pos++;
					ele=list.get(pos);
				}
			}
		}
		if(hayColision)
			return list.get(pos-1);
		else return null;
		*/
	}
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}
