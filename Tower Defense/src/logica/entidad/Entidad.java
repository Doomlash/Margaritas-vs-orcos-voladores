package logica.entidad;

import logica.gameObjects.*;
import logica.mapa.Mapa;
import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;
import logica.premio.magiaTemporal.*;

public abstract class Entidad extends Obstaculo{
	protected CampoDeProteccion escudo;
	protected VisitorColision visitorColision;
	protected VisitorInteraccion visitorAtaque;
	protected int rango,fuerza,fuerzaActual;

	public Entidad(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	public void setFuerza(int f){
		fuerzaActual=f;
	}
	public void setCP(CampoDeProteccion c){
		escudo=c;
	}
	
	public int getFuerza(){
		return fuerzaActual;
	}
	public CampoDeProteccion getCP(){
		return escudo;
	}
}
