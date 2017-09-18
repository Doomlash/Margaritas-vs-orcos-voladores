package logica.juego.niveles;

import logica.juego.*;

public class Nivel2 extends Nivel{

	public Nivel2(Juego j){
		super(j);
	}
	
	public void crearHordas(){
		
	}
	
	public Nivel getSiguiente(){
		return new Nivel3(juego);
	}
}