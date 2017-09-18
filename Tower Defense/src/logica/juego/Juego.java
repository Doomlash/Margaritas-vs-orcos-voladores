package logica.juego;

import logica.juego.niveles.*;
import grafica.gui.*;

public class Juego{
	private GUI gui;
	private Nivel nivel;
	
	/**
	 * Se inicializa el juego con el nivel 1.
	 * @param g : GUI - Se recibe la GUI asociada.
	 */
	public Juego(GUI g){
		gui=g;
		nivel= new Nivel1(this);
	}
	
	/**
	 * Se avanza al siguiente nivel del juego.
	 */
	public void siguienteNivel(){
		nivel= nivel.getSiguiente();
	}
	
	/**
	 * 
	 * @return GUI - Retorna la gui asociada al juego.
	 */
	public GUI getGui(){
		return gui;
	}
	
	/**
	 * 
	 * @return Nivel - Retorna el nivel actual del juego.
	 */
	public Nivel getNivel(){
		return nivel;
	}
}