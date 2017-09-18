package logica.juego.niveles;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class Horda{
	private List<Enemigo> intermedios;
	private List<Enemigo> finales;
	
	/**
	 * Inicializa dos listas de enemigos.
	 * intermedios hace referencia a una grupo de enemigos que se envian individualmente o de a 
	 * pequeños grupos.
	 * finales hace referencia a un grupo de enemigos que serán enviados de forma masiva al final 
	 * de cada horda
	 */
	public Horda(){
		intermedios = new ArrayList<Enemigo>();
		finales = new ArrayList<Enemigo>();
	}
	
	/**
	 * Agrega un enemigo a la lista de enemigos intermedios.
	 * @param e : Enemigo
	 */
	public void agregarIntermedio(Enemigo e){
		intermedios.add(e);
	}
	
	/**
	 * Agrega un enemigo a final.
	 * @param e : Enemigo
	 */
	public void agregarFinal(Enemigo e){
		finales.add(e);
	}
	
	/**
	 * 
	 * @return Iterable<Enemigo> - Retorna un iterable de enemigos conteniendo aquellos enemigos 
	 * que conforman la oleada intermedia de la horda.
	 */
	public Iterable<Enemigo> getIntermedios(){
		return intermedios;
	}
	
	/**
	 * 
	 * @return Iterable<Enemigo> - Retorna un iterable de enemigos conteniendo aquellos enemigos 
	 * pertenecientes al final de la horda.
	 */
	public Iterable<Enemigo> getFinales(){
		return finales;
	}
}