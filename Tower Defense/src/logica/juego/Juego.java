package logica.juego;

import logica.juego.niveles.*;
import logica.almacen.*;
import logica.hilos.*;
import Musica.Player;
import grafica.gui.*;

public class Juego{
	private GUI gui;
	private Nivel nivel;
	private Almacen_Mercado almacen;
	private int puntaje;
	private int tiempo;
	private Generador generador;
	
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
	public Nivel siguienteNivel(){
		nivel= nivel.getSiguiente();
		return nivel;
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
		finalizar();
		Player player= new Player();
		player.playSound();
		gui.getPanelPrincipal().remove(nivel.getMapa().getMapaGrafico());
		gui.getPanelPrincipal().repaint();
		gui.finalizar("Perdiste!");
	}
	public void finalizar(){
		nivel.getMapa().clear();
		nivel.getMapa().getAlmacenHilos().terminateAll();
		generador.terminate();
		almacen.desactivar();
	}
	public void iniciar(){
		if(generador==null){
			generador = new Generador(this);
			generador.start();
		}
	}
	public void ganar(){
		almacen.desactivar();
		gui.finalizar("Ganaste!");
	}
	public void pausar(){
		nivel.getMapa().getAlmacenHilos().pausar();
		generador.pausar();
		almacen.desactivar();
	}
	public void reanudar(){
		nivel.getMapa().getAlmacenHilos().reanudar();
		generador.reanudar();
		almacen.activar();
	}
}