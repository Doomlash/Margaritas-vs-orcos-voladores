package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;
import logica.premio.objetoPrecioso.*;

public abstract class EstadoEscudo{
	protected Entidad entidad;
	
	public abstract void recibirGolpe(Entidad e);
	public abstract void recibirGolpe(Disparo d);
	public abstract void recibirGolpe(Bomba b);
	public void kill(){}
}