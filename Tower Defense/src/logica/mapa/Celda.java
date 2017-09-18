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
	/**
	 * Retorno la coleccion de elementos almacenados en esta celda
	 * 
	 * @return coleccion iterable de elementos
	 */
	public Iterable<Elemento> getElementos() {
		return lista;
	}
	
	/**
	 * metodo para eleminar elementos de la celda
	 * 
	 * @param e elemento a remover
	 * @return TRUE si se pudo eliniar, FALSE caso contrario
	 */
	public boolean remover(Elemento e){
		return lista.remove(e);
	}
	
	public boolean isEmpty(){
		return lista.isEmpty();
	}
}
