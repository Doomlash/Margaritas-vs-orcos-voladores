package logica.entidad.aliado;

import logica.entidad.*;
import logica.gameObjects.Elemento;
import logica.comprables.*;
import logica.premio.magiaTemporal.*;
import logica.visitor.*;
import logica.mapa.*;
import grafica.entidad.aliado.*;
import grafica.gameObjects.*;

public abstract class Aliado extends Entidad implements Comprable{
	protected int precio;
	protected CabezaDeDragon dragon;
	protected PowerBooster booster;
	protected GraphicAliado grafico;
	protected VisitorAtaqueAliado visitorAtaque;
	
	/**
	 * Crea los visitor asociados a las clases Aliado.
	 * @param x : int
	 * @param y : int
	 * @param dX : int - Indica la dimension del objeto en cuando a ancho
	 * @param m : Mapa
	 */
	public Aliado(int x, int y, int dX, Mapa m){
		super(x,y,dX,m);
		visitorAtaque = new VisitorAtaqueAliado(this);
	}
	
	/**
	 * Invoca al visit del Visitor con su tipo (Aliado)
	 */
	public void accept(Visitor v){
		v.visit(this);
	}
	public void atacarRango(){
		for(int i=(x+dimensionX);i<x+dimensionX+rango;i++){
			Celda c = map.getCelda(i, y);
			if(c!=null){
				for(Elemento e: c.getElementos())
					e.accept(visitorAtaque);
			}
		}
	}
	
	public int getPrecio(){
		return precio;
	}
	
	public void kill(){
		for(int i=0;i<dimensionX;i++)
			map.eliminarElemento(this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}