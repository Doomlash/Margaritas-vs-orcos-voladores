package logica.hilos;

import logica.juego.niveles.*;
import logica.entidad.enemigo.*;

public class Generador extends Thread{
	private Nivel nivel;
	private int tiempo;
	private volatile boolean execute;
	private Horda hordaActual;
	
	public Generador(Nivel n){
		this.nivel=n;
		execute=true;
		tiempo=0;
		hordaActual=n.getHordaActual();
	}
	
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
			if(hordaActual==null){
				nivel.getJuego().siguienteNivel();
			}
			else{
				if(hordaActual.isCompleted()){
					nivel.siguienteHorda();
				}
				else{
					if(hordaActual.hayEnemigos()){
						tiempo++;
						if(hordaActual.getTiempoCreacional()==tiempo){
							tiempo=0;
							Enemigo e = nivel.getHordaActual().getSiguiente();
							nivel.getMapa().agregarElemento(e);
							nivel.getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(e);
							nivel.getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(e);
						}
					}
				}
			}
		}
	}
}