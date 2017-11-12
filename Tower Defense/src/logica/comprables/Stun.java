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
	
	public Stun(AlmacenHilos a, Mapa m){
		almacen=a;
		almacen.getAtaEnemigo().pausar();
		almacen.getMovEnemigo().pausar();
		precio = 40;
		tiempo = 10;
		execute=true;
		this.map=m;
//		grafico = new GraphicStun();
//		map.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void terminate(){
		execute=false;
	}
	public int getPrecio(){
		return precio;
	}
	public void run(){
		while(execute){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			tiempo--;
			if(tiempo<=0)
				kill();
		}
	}
	public void kill(){
		execute=false;
		almacen.asignarStun(null);
		almacen.getAtaEnemigo().reanudar();
		almacen.getMovEnemigo().reanudar();
//		map.getMapaGrafico().removeGraphicElemento(grafico);
	}
}