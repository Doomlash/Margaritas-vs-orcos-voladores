package logica.juego.niveles;

import logica.mapa.*;
import logica.juego.*;

public abstract class Nivel{
	protected Mapa map;
	protected int presupuesto;
	protected Horda[] hordas;
	protected Nivel siguiente;
	protected Juego juego;
	
	public Nivel(Juego j){
		juego=j;
		hordas= new Horda[3];
		map= new Mapa(this);
	}
	
	public abstract void crearHordas();
	
	public Horda[] getHordas(){
		return hordas;
	}
	public abstract Nivel getSiguiente();
	public Juego getJuego(){
		return juego;
	}
}