package logica.juego.niveles;

import logica.mapa.*;
import logica.juego.*;
import logica.hilos.*;

public abstract class Nivel{
	protected Mapa map;
	protected int presupuesto, hordaActual;
	protected Horda[] hordas;
	protected Nivel siguiente;
	protected Juego juego;
	protected Contador contador;
	
	public Nivel(Juego j){
		presupuesto= 400;
		juego=j;
		hordaActual=0;
		hordas= new Horda[3];
		for(int i=0;i<hordas.length;i++)
			hordas[i] = new Horda();
		map= new Mapa(this);
		contador = new Contador(this);
		contador.start();
	}
	
	public abstract void crearHordas();
	public void modificarPresupueto(int p){
		if(p<0)
			presupuesto=0;
		else
			presupuesto = p;
		juego.getGui().actualizarPresupuesto();
		
	}
	public void siguienteHorda(){
		if(hordaActual<hordas.length)
			hordaActual++;
	}
	
	public Mapa getMapa(){
		return map;
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
	public Horda getHordaActual(){
		if(hordaActual<hordas.length)
			return hordas[hordaActual];
		else
			return null;
	}
}