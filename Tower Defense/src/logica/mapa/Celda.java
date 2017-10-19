package logica.mapa;

import logica.gameObjects.*;
import logica.visitor.*;
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
	 * metodo para eleminar elementos de la celda
	 * 
	 * @param e elemento a remover
	 * @return TRUE si se pudo eliminar, FALSE caso contrario
	 */
	public void remover(Elemento e){
		lista.remove(e);
	}
	
	/**
	 * Determina si la celda se encuentra o no vacía
	 * @return : boolean - TRUE = vacia, FALSE = no vacía.
	 */
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
	public Iterable<Elemento> getElementos(){
		return lista;
	}
	public void accept(Visitor v){
		int size= lista.size();
		for(int i=0;i<size;i++)
			lista.get(i).accept(v);
	}
	public void clear(){
		int x= lista.size();
		for(int i=0;i<x;i++)
			lista.get(0).kill();
	}
}
