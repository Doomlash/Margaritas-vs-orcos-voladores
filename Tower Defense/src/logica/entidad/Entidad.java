package logica.entidad;

import logica.gameObjects.*;
import logica.mapa.Mapa;
import logica.premio.magiaTemporal.*;
import logica.visitor.*;

public abstract class Entidad extends Obstaculo{
	protected CampoDeProteccion escudo;
	protected Visitor visitorAtaque;
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
	public abstract void atacar(Obstaculo o);
	public abstract void atacarRango();
}
