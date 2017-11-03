package logica.premio;

import logica.entidad.aliado.*;
import logica.mapa.*;

public abstract class PowerUp{
	protected Aliado aliado;
	protected int tiempo;
	protected Mapa map;
	
	public void reducirTemporizador(){
		tiempo--;
		if(tiempo<=0)
			kill();
	}
	public abstract void afectarAliado();
	public abstract void restaurarAliado();
	public void kill(){
		restaurarAliado();
		map.getAlmacenHilos().getPowerUps().powerUpAEliminar(this);
	}
}