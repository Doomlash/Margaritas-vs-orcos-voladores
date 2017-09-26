package logica.entidad.aliado;

import logica.entidad.*;
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
	
	public void kill(){
		for(int i=0;i<dimensionX;i++)
			map.eliminarElemento(x+i, y, this);
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
	
//	public abstract void atacar();
}