package logica.premio;

import logica.mapa.*;
import logica.entidad.aliado.*;

public abstract class PowerUp{
	protected Mapa map;
	
	public abstract void actualizar();
	public abstract void afectar(Aliado a);
	public abstract void restaurar();
	public void kill(){
		restaurar();
		map.getAlmacenHilos().getPowerUps().powerUpAEliminar(this);
	}
}