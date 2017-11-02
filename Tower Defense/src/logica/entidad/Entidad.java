package logica.entidad;

import logica.gameObjects.*;
import logica.mapa.Mapa;
import logica.entidad.stateEscudo.*;
import logica.disparo.*;

public abstract class Entidad extends Obstaculo{
	protected int rango,fuerza,fuerzaActual,cargaAtaqueActual,cargaAtaqueNecesaria;
	protected EstadoEscudo escudo;

	public Entidad(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
		escudo = new Vulnerable();
	}
	public void setFuerza(int f){
		fuerzaActual=f;
	}
	public EstadoEscudo getEstadoEscudo(){
		return escudo;
	}
	public void setEstadoEscudo(EstadoEscudo e){
		escudo=e;
	}
	
	public int getFuerza(){
		return fuerzaActual;
	}
	public abstract void atacar(Obstaculo o);
	public abstract void atacarRango();
	public void recibirGolpe(Entidad e){
		escudo.recibirGolpe(e);
	}
	public void recibirGolpe(Disparo d){
		escudo.recibirGolpe(d);
	}
}
