package logica.comprables;

import logica.hilos.*;
import logica.mapa.*;
import grafica.comprables.*;

public class Stun extends Thread implements Comprable{
	private int precio, tiempo;
	private volatile boolean execute;
	private AlmacenHilos almacen;
	private GraphicStun grafico;
	private Mapa map;
	protected boolean pausa=false;
	
	public Stun(AlmacenHilos a, Mapa m){
		almacen=a;
		almacen.getAtaEnemigo().congelar();
		almacen.getMovEnemigo().congelar();
		precio = 200;
		tiempo = 7;
		execute=true;
		this.map=m;
		grafico = new GraphicStun();
		map.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
	}
	public void terminate(){
		execute=false;
	}
	public int getPrecio(){
		return precio;
	}
	public void run(){
		while(execute){
			if(!pausa){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				tiempo--;
				if(tiempo<=0)
					kill();
			}
		}
	}
	public void kill(){
		execute=false;
		almacen.asignarStun(null);
		almacen.getAtaEnemigo().descongelar();
		almacen.getMovEnemigo().descongelar();
		map.getMapaGrafico().removeGraphicElemento(grafico);
	}
}