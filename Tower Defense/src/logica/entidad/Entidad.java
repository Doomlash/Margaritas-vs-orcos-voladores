package logica.entidad;

import logica.gameObjects.*;
import logica.mapa.Mapa;
import logica.entidad.stateEscudo.*;
import logica.disparo.*;
import logica.premio.objetoPrecioso.*;

public abstract class Entidad extends Obstaculo{
	protected int rango,fuerza,cargaAtaqueActual,cargaAtaqueNecesaria;
	protected EstadoEscudo escudo;
	protected int duracionAtaque; //En segundos

	public Entidad(int x, int y, int dx, int dy, Mapa m){
		super(x,y,dx,dy,m);
		escudo = new Vulnerable(this);
	}
	public EstadoEscudo getEstadoEscudo(){
		return escudo;
	}
	public void setEstadoEscudo(EstadoEscudo e){
		escudo=e;
	}
	
	public int getCargaAtaqueNecesaria(){
		return cargaAtaqueNecesaria;
	}
	public void setCargaAtaqueNececaria(int c){
		if(c>=duracionAtaque)
			cargaAtaqueNecesaria=c;
	}
	public abstract void atacar(Obstaculo o);
	public abstract void atacarRango();
	public void recibirGolpe(Entidad e){
		escudo.recibirGolpe(e);
	}
	public void recibirGolpe(Disparo d){
		escudo.recibirGolpe(d);
	}
	public void recibirGolpe(Bomba b){
		escudo.recibirGolpe(b);
	}
	public void setDuracionAtaque(int d){
		duracionAtaque=d;
	}
	public int getDuracionAtaque(){
		return duracionAtaque;
	}
}
