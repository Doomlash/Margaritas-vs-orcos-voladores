package logica.entidad.aliado;

import logica.entidad.*;
import logica.comprables.*;
import logica.premio.magiaTemporal.*;
import logica.visitor.*;
import logica.mapa.*;
import logica.modificador_PowerUp.Modificador;
import grafica.entidad.aliado.*;
import grafica.gameObjects.*;

public abstract class Aliado extends Entidad implements Comprable{
	protected int precio;
	protected Stun dragon;
	protected PowerBooster booster;
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
		if(cargaAtaqueActual>=cargaAtaqueNecesaria){
			cargaAtaqueActual=0;
			for(int i=(x+dimensionX);i<x+dimensionX+rango;i++){
				Celda c = map.getCelda(i, y);
				if(c!=null){
				c.accept(visitorAtaque);
				}
			}
		}
		else
			cargaAtaqueActual++;
	}
	
	public int getPrecio(){
		return precio;
	}
	public void afectar(Modificador m){
		m.afectar(this);
	}
	
	public void kill(){
		visitorAtaque.kill();
		((GraphicAliado)grafico).morir();
		map.getAlmacenHilos().getAtaAliado().aliadoAEliminar(this);
		map.eliminarElemento(this);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}