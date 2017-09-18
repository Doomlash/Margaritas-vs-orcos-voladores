package logica.mapa;

import logica.gameObjects.*;

import java.util.ArrayList;
import java.util.List;

public class Celda{
	private List<Elemento> lista;

	public Celda(){
		lista = new ArrayList<Elemento>();
	}
	
	public void agregarElemento(Elemento e){
		lista.add(e);
	}

	public List<Elemento> getElementos() {
		return lista;
	}
}
