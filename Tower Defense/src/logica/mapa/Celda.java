package logica.mapa;

import logica.gameObjects.*;
import java.util.ArrayList;
import java.util.List;

public class Celda{
	private List<Elemento> lista;

	public Celda(){
		lista = new ArrayList<Elemento>();
	}
	
	/**
	 * Agrega el elemento e a la lista.
	 * @param e : Elemento
	 */
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
	 * @return TRUE si se pudo eliminar, FALSE caso contrario
	 */
	public boolean remover(Elemento e){
		return lista.remove(e);
	}
	
	/**
	 * Determina si la celda se encuentra o no vac�a
	 * @return : boolean - TRUE = vacia, FALSE = no vac�a.
	 */
	public boolean isEmpty(){
		return lista.isEmpty();
	}
}
