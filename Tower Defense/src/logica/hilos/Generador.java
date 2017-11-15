package logica.hilos;

import logica.juego.*;
import logica.juego.niveles.*;
import logica.entidad.enemigo.*;

public class Generador extends Thread{
	private Juego juego;
	private Nivel nivelActual;
	private Horda hordaActual;
	private int tiempo;
	private int tiempoInicialEspera;
	private volatile boolean execute;
	protected boolean pausa=false;
	
	public Generador(Juego j){
		this.juego=j;
		this.nivelActual=juego.getNivel();
		execute=true;
		tiempo=0;
		hordaActual=nivelActual.getHordaActual();
		tiempoInicialEspera=0;
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
				if(tiempoInicialEspera<7){
					tiempoInicialEspera++;
				}
				else{
					if(hordaActual==null){
						nivelActual = juego.siguienteNivel();
						juego.getGui().actualizarNumHordas();
						if(nivelActual==null)
							juego.ganar();
						else{
							hordaActual=nivelActual.getHordaActual();
						}
						juego.getGui().repaint();
						tiempoInicialEspera=0;
					}
					else{
						if(hordaActual.isCompleted()){
							nivelActual.siguienteHorda();
							hordaActual=nivelActual.getHordaActual();
							if(execute)
								juego.getGui().actualizarNumHordas();
							if(hordaActual!=null)
								nivelActual.getMapa().agregarObstaculos(3, 3);
						}
						else{
							if(hordaActual.hayEnemigos()){
								tiempo++;
								if(hordaActual.getTiempoCreacional()==tiempo){
									tiempo=0;
									Enemigo e = nivelActual.getHordaActual().getSiguiente();
									nivelActual.getMapa().agregarElemento(e);
									nivelActual.getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(e);
									nivelActual.getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(e);
								}
							}
						}
					}
				}
			}
		}
	}
}