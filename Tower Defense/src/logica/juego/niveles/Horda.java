package logica.juego.niveles;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class Horda{
	private List<Enemigo> enemigos;
	private int tiempoCreacional;
	
	public Horda(){
		enemigos = new ArrayList<Enemigo>();
	}
	
	public void setTiempoCreacional(int t){
		tiempoCreacional=t;
	}
	public int getTiempoCreacional(){
		return tiempoCreacional;
	}
	public void agregar(Enemigo e){
		enemigos.add(e);
	}
	
	public Enemigo getSiguiente(){
		if(!enemigos.isEmpty())
			return enemigos.remove(0);
		return null;
	}
	
	public boolean isEmpty(){
		return enemigos.isEmpty();
	}
}