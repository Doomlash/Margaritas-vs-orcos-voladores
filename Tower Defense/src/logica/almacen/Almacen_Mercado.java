package logica.almacen;

import logica.juego.*;
import logica.mapa.*;
import grafica.almacen.*;

public class Almacen_Mercado{
	private Almacen_Mercado_Panel almacen;
	private Juego juego;
	private Creador creador;
	
	public Almacen_Mercado(Juego j){
		this.juego = j;
		almacen = new Almacen_Mercado_Panel(this);
	}
	
	public Almacen_Mercado_Panel getAlmacenPanel(){
		return almacen;
	}
	public Juego getJuego(){
		return juego;
	}
	public void crearObjeto(int x, int y, Mapa m){
		if(creador!=null){
			creador.agregar(x, y, m);
			creador = null;
		}
	}
	public void asignarCreador(Creador c){
		this.creador = c;
		
	}
}