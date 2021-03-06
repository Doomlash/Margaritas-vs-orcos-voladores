package logica.entidad;

import logica.gameObjects.*;
import logica.mapa.Mapa;
import logica.modificador_PowerUp.ModificadorEntidad;
import logica.entidad.DirectorPowerUp.*;
import logica.entidad.stateEscudo.*;

public abstract class Entidad extends Obstaculo{
	protected int rango,fuerza,cargaAtaqueActual,cargaAtaqueNecesaria;
	protected EstadoEscudo escudo;
	protected int duracionAtaque; //En segundos
	protected DirectorPowerUp director;

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
	public void setDuracionAtaque(int d){
		duracionAtaque=d;
	}
	public int getDuracionAtaque(){
		return duracionAtaque;
	}
	public void setFuerza(int f){
		fuerza=f;
	}
	public int getFuerza(){
		return fuerza;
	}
	public DirectorPowerUp getDirector(){
		return director;
	}
	public abstract void afectar(ModificadorEntidad m);
}
