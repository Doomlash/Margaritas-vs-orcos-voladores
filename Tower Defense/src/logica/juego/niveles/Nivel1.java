package logica.juego.niveles;

import logica.juego.*;

public class Nivel1 extends Nivel{
	
	public Nivel1(Juego j){
		super(j);
	}
	
	public void crearHordas(){
		
	}
	
	public Nivel getSiguiente(){
		return new Nivel2(juego);
	}
}