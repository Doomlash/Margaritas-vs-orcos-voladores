package logica.juego.niveles;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class Horda{
	private List<Enemigo> intermedios;
	private List<Enemigo> finales;
	private int id;
	
	public Horda(){
		intermedios = new ArrayList<Enemigo>();
		finales = new ArrayList<Enemigo>();
	}
	
	public void agregarIntermedio(Enemigo e){
		intermedios.add(e);
	}
	public void agregarFinal(Enemigo e){
		finales.add(e);
	}
	
	public List<Enemigo> getIntermedios(){
		return intermedios;
	}
	public List<Enemigo> getFinales(){
		return finales;
	}
	public int getID(){
		return id;
	}
}