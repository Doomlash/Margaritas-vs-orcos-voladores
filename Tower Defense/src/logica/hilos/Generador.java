package logica.hilos;

import logica.juego.*;
import logica.juego.niveles.*;
import logica.entidad.enemigo.*;

public class Generador extends Thread{
	private Juego juego;
	private Nivel nivelActual;
	private Horda hordaActual;
	private int tiempo, numEne, cantEne;
	private int tiempoInicialEspera;
	private volatile boolean execute;
	protected boolean pausa=false;
	
	public Generador(Juego j){
		this.juego=j;
		this.nivelActual=juego.getNivel();
		if(nivelActual!=null)
			cantEne=nivelActual.getCantEnemigosTotal();
		numEne=0;
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
						juego.getGui().getPanelSuperior().actualizarNumHordas();
						if(nivelActual==null)
							juego.ganar();
						else{
							hordaActual=nivelActual.getHordaActual();
							cantEne=nivelActual.getCantEnemigosTotal();
							numEne=0;
							juego.getGui().getPanelSuperior().actualizarLevelProgress(numEne, cantEne);
						}
						juego.getGui().repaint();
						tiempoInicialEspera=0;
					}
					else{
						if(hordaActual.isCompleted()){
							nivelActual.siguienteHorda();
							hordaActual=nivelActual.getHordaActual();
							if(execute)
								juego.getGui().getPanelSuperior().actualizarNumHordas();
							if(hordaActual!=null)
								nivelActual.getMapa().agregarObstaculos(3, 3);
						}
						else{
							if(hordaActual.hayEnemigos()){
								tiempo++;
								if(hordaActual.getTiempoCreacional()==tiempo){
									numEne++;
									juego.getGui().getPanelSuperior().actualizarLevelProgress(numEne, cantEne);
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