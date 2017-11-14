package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;
import logica.premio.objetoPrecioso.*;

public class Vulnerable extends EstadoEscudo{
	
	public Vulnerable(Entidad e){
		this.entidad=e;
	}
	public void recibirGolpe(Entidad e){
		
	}
	public void recibirGolpe(Disparo d){
		
	}
	public void recibirGolpe(Trampa t){
		entidad.setVida(entidad.getVida()-t.getDamage());
		t.kill();
	}
	public void recibirGolpe(Bomba b){
		b.agregarObjetivo(entidad);
	}
}