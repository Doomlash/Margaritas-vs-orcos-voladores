package logica.modificador_PowerUp;

import logica.mapa.*;

public abstract class Modificador{
	protected Mapa map;
	
	public abstract void actualizar();
	public void kill(){
		map.getAlmacenHilos().getPowerUps().powerUpAEliminar(this);
	}
}