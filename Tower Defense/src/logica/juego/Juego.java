package logica.juego;

import logica.juego.niveles.*;
import logica.almacen.*;
import grafica.gui.*;

public class Juego{
	private GUI gui;
	private Nivel nivel;
	private Almacen_Mercado almacen;
	private int puntaje;
	private int tiempo;
	
	/**
	 * Se inicializa el juego con el nivel 1.
	 * @param g : GUI - Se recibe la GUI asociada.
	 */
	public Juego(GUI g){
		gui=g;
		nivel= new Nivel1(this);
		almacen = new Almacen_Mercado(this);
		puntaje=0;
		tiempo=0;
	}
	public void aumentarPuntaje(int p){
		if(p>0)
			puntaje+=p;
		gui.actualizarPuntaje();
	}
	public void aumentarTemporizador(){
		tiempo++;
		gui.actualizarTemporizador();
	}
	public int getTiempo(){
		return tiempo;
	}
	public void siguienteNivel(){
		nivel= nivel.getSiguiente();
	}
	public GUI getGui(){
		return gui;
	}
	public Nivel getNivel(){
		return nivel;
	}
	public Almacen_Mercado getAlmacen(){
		return almacen;
	}
	public int getPuntaje(){
		return puntaje;
	}
	public void perder(){
		nivel.getMapa().getAlmacenHilos().terminateAll();
		almacen.desactivar();
		nivel.finalizar();
		nivel.getMapa().clear();
//		gui.finalizar();
	}
}