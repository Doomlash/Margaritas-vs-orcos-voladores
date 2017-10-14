
package logica.entidad.enemigo;

import logica.entidad.*;
import logica.gameObjects.Elemento;
import logica.mapa.*;
import logica.visitor.*;
import grafica.entidad.enemigo.*;
import grafica.gameObjects.*;

public abstract class Enemigo extends Entidad{
	protected int velocidad;
	protected int puntaje;
	protected int monedas;
	protected volatile boolean execute;
	protected GraphicEnemigo grafico;
	protected boolean canMove;
	
	/**
	 * 
	 * @param x : int
	 * @param y : int
	 * @param dx : int - Indica la dimension del objeto en cuando a ancho
	 * @param m : Mapa
	 */
	public Enemigo(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
		visitorAtaque = new VisitorAtaqueEnemigo(this);
		this.execute=true;
		canMove=false;
	}
	
	/**
	 * Invoca al visit del visitor indicando su tipo (Enemigo)
	 */
	public void accept(Visitor v){
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
	 */
	public void move(){
		if(x-1>=0&&execute){
			int aux= grafico.getPos().x-grafico.getWidthUnaCelda();
			grafico.cambiarPos(grafico.getPos().x-velocidad*2, grafico.getPos().y);
			
			if(grafico.getPos().x>aux){
				if(execute)
					map.getCelda(x-1, y).agregarElemento(this);
				if(x<10)
					map.getCelda(x, y).remover(this);
			}
		}
	}
	
	public void atacarRango(){
		for(int i=(x-1);i>=x-rango;i--){
			Celda c = map.getCelda(i, y);
			if(c!=null){
				for(Elemento e: c.getElementos())
					e.accept(visitorAtaque);
			}
		}
	}
	
	public void kill(){
		map.getNivel().getJuego().aumentarPuntaje(puntaje);
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()+monedas);
		for(int i=0;i<dimensionX;i++)
			map.eliminarElemento(x+i, y, this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
	
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}
