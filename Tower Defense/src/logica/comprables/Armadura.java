package logica.comprables;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.*;
import logica.modificador_PowerUp.Modificador;

public class Armadura extends Modificador implements Comprable{
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
	public void afectar(Enemigo e){
		
	}
	public void restaurar(){
		aliado.setVidaMax(vidaMaxGuardada);
	}
}