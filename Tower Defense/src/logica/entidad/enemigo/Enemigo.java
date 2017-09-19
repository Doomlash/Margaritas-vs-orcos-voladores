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
	
	/**
	 * 
	 * @param x : int
	 * @param y : int
	 * @param dx : int - Indica la dimension del objeto en cuando a ancho
	 * @param m : Mapa
	 */
	public Enemigo(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
		visitorColision = new VisitorColisionEnemigo();
		visitorAtaque = new VisitorAtaqueEnemigo(this);
		this.execute=true;
	}
	
	/**
	 * Invoca al visit del visitor indicando su tipo (Enemigo)
	 */
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	/**
	 * Termina el hilo
	 */
	public void terminate(){
		execute=false;
	}
	
	/**
	 * Actualiza la posicion logica y grafica del enemigo al moverse
	 * @throws InterruptedException
	 */
	public void move() throws InterruptedException{
		if(x-1>=0){
			int aux= grafico.getPos().x-grafico.getWidth();
			while(grafico.getPos().x>aux){
				grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y);
				map.getMapaGrafico().repaint();
				Thread.sleep(100);
//				grafico.getGrafico().repaint();
			}
			map.getCelda(x-1, y).agregarElemento(this);
			if(x<10)
				map.getCelda(x, y).remover(this);
		}
	}
	
	/**
	 * Chequea la colision con la siguiente celda. Si ésta está vacía o si los elementos que 
	 * se encuentran en la celda le permiten al enemigo avanzar, se retorna true, sino se 
	 * retorna false.
	 * @return boolean
	 */
	public boolean canMove(){
		int nextX = x-1;
		boolean hayColision=false;
		Iterable<Elemento> list = map.getCelda(nextX, y).getElementos();
		if(nextX>=0){
			for(Elemento e : list){
				if(!hayColision){
					hayColision = e.accept(visitorColision);
				}
			}
		}
		return !hayColision;
	}
	
	/**
	 * Chequea si dentro del rango de celdas hay un elemento que puede ser atacado por un enemigo.
	 * El rango de ataque se chequea de derecha a izquierda. Si hay un elemento para atacar se 
	 * retorna ese elemento, sino se retorna nulo.
	 * @param k : int - Inicio del rango de ataque
	 * @param f : int - Fin del rango de ataque
	 * @return Elemento
	 */
	public Elemento chequearColision(int k, int f){
		Iterable<Elemento> list = null;
		for(int i=k;(i<=f);i--){
			list=map.getCelda(i, this.y).getElementos();
			for(Elemento e : list)
				if(e.accept(visitorColision))
					return e;
		}
		return null;
	}
	
	/**
	 * Invoca al visit del visitor indicando su tipo (Enemigo)
	 * @return boolean
	 */
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
}
