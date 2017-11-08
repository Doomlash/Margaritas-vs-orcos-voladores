package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;
import logica.premio.objetoPrecioso.*;
import logica.premio.magiaTemporal.*;

public class Invulnerable extends EstadoEscudo{
	private Escudo escudo;
	
	public Invulnerable(Entidad e, Escudo esc){
		this.entidad=e;
		this.escudo=esc;
	}
	public void recibirGolpe(Entidad e){
		e.kill();
		escudo.kill();
	}
	public void recibirGolpe(Disparo d){
		d.kill();
	}
	public void recibirGolpe(Bomba b){
		
	}
	public void kill(){
		escudo.kill();
	}
}