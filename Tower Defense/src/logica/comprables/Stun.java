package logica.comprables;

import logica.hilos.*;

public class Stun extends Thread implements Comprable{
	private int precio, tiempo;
	private volatile boolean execute;
	private AlmacenHilos almacen;
	
	public Stun(AlmacenHilos a){
		almacen=a;
		almacen.getAtaEnemigo().pausar();
		almacen.getMovEnemigo().pausar();
		precio = 40;
		tiempo = 10;
		execute=true;
	}
	public void terminate(){
		execute=false;
	}
	public void reducirTemporizador(){
		tiempo--;
	}
	public void resetearTemporizador(){
		tiempo=10;
	}
	public int getTiempo(){
		return tiempo;
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
		almacen.deleteStun();
		almacen.getAtaEnemigo().reanudar();
		almacen.getMovEnemigo().reanudar();
	}
}