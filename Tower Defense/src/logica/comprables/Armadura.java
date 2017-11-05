package logica.comprables;

import logica.premio.*;
import logica.entidad.aliado.*;
import logica.mapa.*;

public class Armadura extends PowerUp implements Comprable{
	private int precio;
	private int vidaMaxGuardada, vidaActualGuardada;
	private Aliado aliado;
	
	public Armadura(Aliado a, Mapa m){
		this.map = m;
		precio = 40;
	}
	public void actualizar(){
		
	}
	public int getPrecio(){
		return precio;
	}
	
	public void afectar(Aliado a){
		this.aliado=a;
		vidaMaxGuardada = aliado.getVidaMax();
		aliado.setVidaMax(vidaMaxGuardada+100);
		vidaActualGuardada = aliado.getVida();
		aliado.setVida(vidaActualGuardada+100);
	}
	
	public void restaurar(){
		aliado.setVidaMax(vidaMaxGuardada);
	}
}