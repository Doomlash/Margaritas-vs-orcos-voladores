package logica.juego;

import logica.juego.niveles.*;
import logica.almacen.*;
import logica.hilos.*;
import Musica.Player;
import grafica.gui.*;

public class Juego{
	private PanelJuego gui;
	private Nivel nivel;
	private Almacen_Mercado almacen;
	private int puntaje;
	private int tiempo;
	private Generador generador;
	private Player player;
	
	/**
	 * Se inicializa el juego con el nivel 1.
	 * @param g : GUI - Se recibe la GUI asociada.
	 */
	public Juego(PanelJuego g){
		gui=g;
		nivel= new Nivel1(this);
		almacen = new Almacen_Mercado(this);
		puntaje=0;
		tiempo=0;
		player= new Player();
	}
	public void aumentarPuntaje(int p){
		if(p>0)
			puntaje+=p;
		gui.getPanelSuperior().actualizarPuntaje();
	}
	public void aumentarTemporizador(){
		tiempo++;
		gui.getPanelSuperior().actualizarTemporizador();
	}
	public int getTiempo(){
		return tiempo;
	}
	public Nivel siguienteNivel(){
		nivel= nivel.getSiguiente();
		return nivel;
	}
	public PanelJuego getGui(){
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
		player.playDerrota();
		gui.perder();
		gui.finalizar();
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
		generador.terminate();
		gui.finalizar();
		player.playVictoria();
		gui.ganar();
	}
	public void pausar(){
		if(nivel!=null)
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