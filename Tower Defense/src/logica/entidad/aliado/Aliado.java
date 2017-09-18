package logica.entidad.aliado;

import logica.entidad.*;
import logica.gameObjects.*;
import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.comprables.*;
import logica.premio.magiaTemporal.*;
//import java.util.List;
import logica.mapa.Mapa;

public abstract class Aliado extends Entidad implements  Comprable{
	protected int precio;
	protected CabezaDeDragon dragon;
	protected PowerBooster booster;
	
	/**
	 * Crea los visitor asociados a las clases Aliado.
	 * @param x : int
	 * @param y : int
	 * @param dX : int - Indica la dimension del objeto en cuando a ancho
	 * @param m : Mapa
	 */
	public Aliado(int x, int y, int dX, Mapa m){
		super(x,y,dX,m);
		visitorColision = new VisitorColisionAliado();
		visitorAtaque = new VisitorAtaqueAliado(this);
	}
	
	/**
	 * Invoca al visit del Visitor con su tipo (Aliado)
	 */
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public int getPrecio(){
		return precio;
	}
	
	/**
	 *  Invoca al visit del Visitor con su tipo (Aliado)
	 *  @return boolean
	 */
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
	
	/**
	 * Chequea si dentro del rango de ataque hay un elemento que puede ser atacado por un aliado.
	 * Si hay un elemento a ser atacado, retorn dicho elemento, sino retorna nulo.
	 * Se chequea el rango de izquierda a derecha.
	 * @param k : int - Inicio de rango
	 * @param f : int - Fin de rango
	 * @return Elemento
	 */
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
	}
	
//	public abstract void atacar();
}