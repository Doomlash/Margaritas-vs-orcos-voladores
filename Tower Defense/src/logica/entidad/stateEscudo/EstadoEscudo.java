package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;

public abstract class EstadoEscudo{
	
	public abstract void recibirGolpe(Entidad e);
	public abstract void recibirGolpe(Disparo d);
	public void stop(){}
}