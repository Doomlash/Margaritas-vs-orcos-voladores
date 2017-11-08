package logica.modificador_PowerUp;

import logica.mapa.*;
import logica.entidad.*;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;

public abstract class Modificador{
	protected Mapa map;
	protected Entidad entidad;
	
	public abstract void actualizar();
	public abstract void afectar(Aliado a);
	public abstract void afectar(Enemigo e);
	public abstract void restaurar();
	public void kill(){
		restaurar();
		map.getAlmacenHilos().getPowerUps().powerUpAEliminar(this);
	}
}