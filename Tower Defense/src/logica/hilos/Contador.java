package logica.hilos;

import logica.juego.*;

public class Contador extends Thread{
	private Juego juego;
	private volatile boolean execute;
	protected boolean pausa=false;
	
	public Contador(Juego j){
		this.juego=j;
		execute=true;
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
	public void run(){
		while(execute){
			if(!pausa){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
				}
				juego.aumentarTemporizador();
			}
		}
	}
}
