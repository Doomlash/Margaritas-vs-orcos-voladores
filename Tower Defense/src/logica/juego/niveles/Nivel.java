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
		presupuesto= 400;
		juego=j;
		hordas= new Horda[3];
		for(int i=0;i<hordas.length;i++)
			hordas[i] = new Horda();
		map= new Mapa(this);
	}
	
	public abstract void crearHordas();
	public void modificarPresupueto(int p){
		presupuesto = p;
	}
	
	public Mapa getMapa(){
		return map;
	}
	public Horda[] getHordas(){
		return hordas;
	}
	
	/**
	 * 
	 * @return Nivel - Retorna el siguiente Nivel al actual. Nulo si el actual no contiene siguiente.
	 */
	public abstract Nivel getSiguiente();
	public int getPresupuesto(){
		return presupuesto;
	}
	public Juego getJuego(){
		return juego;
	}
}