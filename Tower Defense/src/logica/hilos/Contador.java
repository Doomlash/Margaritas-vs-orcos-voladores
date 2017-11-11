package logica.hilos;

import logica.juego.*;

public class Contador extends Thread{
	private Juego juego;
	private volatile boolean execute;
	
	public Contador(Juego j){
		this.juego=j;
		execute=true;
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
			juego.aumentarTemporizador();
		}
	}
}
