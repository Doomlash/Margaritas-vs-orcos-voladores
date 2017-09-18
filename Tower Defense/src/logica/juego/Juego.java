package logica.juego;

import logica.juego.niveles.*;
import logica.comprables.*;
import logica.mapa.*;
import grafica.gui.*;

import java.util.List;
import java.util.ArrayList;

public class Juego{
	private GUI gui;
	private Nivel nivel;
	private List<Comprable> listaComprables;
	
	public Juego(GUI g){
		gui=g;
		nivel= new Nivel1(this);
		listaComprables = new ArrayList<Comprable>();
	}
	
	public void siguienteNivel(){
		nivel= nivel.getSiguiente();
	}
	public List<Comprable> getComprables(){
		return listaComprables;
	}
	public GUI getGui(){
		return gui;
	}
	public Nivel getNivel(){
		return nivel;
	}
}