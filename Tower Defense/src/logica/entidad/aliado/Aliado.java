package logica.entidad.aliado;

import logica.entidad.*;
import logica.entidad.enemigo.*;
import logica.comprables.*;

public abstract class Aliado extends Entidad implements  Comprable{
	protected int precio;
	protected CabezaDeDragon dragon;
	
	public int getPrecio(){
		return precio;
	}
/*	public Celda chequearRango(int d, int h){
		
	}
*/
	public boolean colision(Enemigo e){
		return true;
	}
	public boolean colision(Aliado a){
		return false;
	}
	public boolean accept(CabezaDeDragon c){
		dragon=c;
		return true;
	}
}