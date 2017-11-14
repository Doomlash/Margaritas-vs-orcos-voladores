package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;
import logica.premio.magiaTemporal.Escudo;
import logica.premio.objetoPrecioso.*;

public abstract class EstadoEscudo{
	protected Entidad entidad;
	protected Escudo escudo;
	
	public abstract void recibirGolpe(Entidad e);
	public abstract void recibirGolpe(Disparo d);
	public abstract void recibirGolpe(Bomba b);
	public abstract void recibirGolpe(Trampa b);
	public void kill(){
		if(escudo!=null)
			escudo.kill();
	}
}