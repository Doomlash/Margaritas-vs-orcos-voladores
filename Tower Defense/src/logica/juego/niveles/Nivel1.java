package logica.juego.niveles;

import logica.juego.*;

public class Nivel1 extends Nivel{
	
	public Nivel1(Juego j){
		super(j);
	}
	
	public void crearHordas(){
		for(int i=0;i<8;i++){
//			hordas[0].agregarIntermedio(new );
		}
	}
	
	public Nivel getSiguiente(){
		return new Nivel2(juego);
	}
}