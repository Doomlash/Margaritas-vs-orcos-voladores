package logica.modificador_PowerUp;

import logica.entidad.Entidad;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;

public abstract class ModificadorEntidad extends Modificador{
	protected Entidad entidad;

	public abstract void afectar(Aliado a);
	public abstract void afectar(Enemigo e);
	public abstract void restaurar();
	public void kill(){
		restaurar();
		super.kill();
	}
}