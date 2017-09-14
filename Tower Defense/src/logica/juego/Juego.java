package logica.juego;

import logica.juego.niveles.*;

public class Juego{
	private Nivel nivel;
	
	public Juego(){
		nivel= new Nivel1();
	}
	
	public void siguienteNivel(){
		nivel= nivel.getSiguiente();
	}
}