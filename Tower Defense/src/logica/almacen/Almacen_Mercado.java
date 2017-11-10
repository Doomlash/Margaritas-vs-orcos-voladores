package logica.almacen;

import logica.juego.*;
import logica.mapa.*;
import grafica.almacen.*;

public class Almacen_Mercado{
	private Almacen_Mercado_Panel almacen;
	private Juego juego;
	private Accion accion;
	private boolean activo;
	
	public Almacen_Mercado(Juego j){
		this.juego = j;
		almacen = new Almacen_Mercado_Panel(this);
		activo=true;
	}
	
	public Almacen_Mercado_Panel getAlmacenPanel(){
		return almacen;
	}
	public Juego getJuego(){
		return juego;
	}
	public void ejecutarAccion(int x, int y, Mapa m){
		if(accion!=null&&activo){
			accion.ejecutarAccion(x, y, m);
			accion = null;
		}
	}
	public void asignarAccion(Accion c){
		this.accion = c;
	}
	public void desactivar(){
		activo=false;
	}
}