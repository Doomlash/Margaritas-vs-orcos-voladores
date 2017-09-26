
package logica.entidad.enemigo;

import logica.entidad.*;
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
		if(x-1>=0&&execute){
			int aux= grafico.getPos().x-grafico.getWidth();
			while(grafico.getPos().x>aux){
				grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y);
				Thread.sleep(100);
				grafico.getGrafico().repaint();
			}
			if(execute)
				map.getCelda(x-1, y).agregarElemento(this);
			if(x<10)
				map.getCelda(x, y).remover(this);
		}
	}
	
	/**
	 * Invoca al visit del visitor indicando su tipo (Enemigo)
	 * @return boolean
	 */
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
	public void kill(){
		map.getNivel().getJuego().aumentarPuntaje(puntaje);
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()+monedas);
		for(int i=0;i<dimensionX;i++)
			map.eliminarElemento(x+i, y, this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
}
