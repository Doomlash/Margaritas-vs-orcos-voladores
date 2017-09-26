package logica.juego.niveles;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class Horda{
	private List<Enemigo> intermedios;
	private List<Enemigo> finales;
	private int in,fin;
	
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
		in = 0;
		fin = 0;
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
	 * @return Enemigo : El siguiente enemigo a agregar de la oleada intermedia. Nulo si ya se 
	 * agregaron todos los enemigos de la lista intermedios.
	 */
	public Enemigo getSiguienteIntermedio(){
		Enemigo e=null;
		if(in<intermedios.size()){
			e = intermedios.get(in);
			in++;
		}
		return e;
	}
	
	/**
	 * 
	 * @return Enemigo : El siguiente enemigo a agregar de la oleada final. Nulo si ya se 
	 * agregaron todos los enemigos de la lista finales.
	 */
	public Enemigo getSiguienteFinal(){
		Enemigo e=null;
		if(fin<finales.size()){
			e = finales.get(fin);
			fin++;
		}
		return e;
	}
	
	public boolean completed(){
		return finales.isEmpty();
	}
}