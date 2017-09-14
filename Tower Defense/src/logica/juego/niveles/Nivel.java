package logica.juego.niveles;

import logica.mapa.*;

public abstract class Nivel{
	protected Mapa map;
	protected int presupuesto;
	protected Horda[] hordas;
	protected Nivel siguiente;
	
	public Nivel(){
		hordas= new Horda[3];
		map= new Mapa(this);
	}
	
//	public abstract void createHordas();
	
	public Horda[] getHordas(){
		return hordas;
	}
	public Nivel getSiguiente(){
		return siguiente;
	}
}