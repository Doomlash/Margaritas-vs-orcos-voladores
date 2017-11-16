package logica.juego.niveles;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class Horda{
	private List<Enemigo> enemiesToSend, enemiesInMap;
	private int tiempoCreacional;
	
	public Horda(){
		enemiesToSend = new ArrayList<Enemigo>();
		enemiesInMap = new ArrayList<Enemigo>();
	}
	public int cantEnemigos(){
		return enemiesToSend.size();
	}
	
	public void setTiempoCreacional(int t){
		tiempoCreacional=t;
	}
	public int getTiempoCreacional(){
		return tiempoCreacional;
	}
	public void agregar(Enemigo e){
		enemiesToSend.add(e);
	}
	public boolean hayEnemigos(){
		return !enemiesToSend.isEmpty();
	}
	public Enemigo getSiguiente(){
		if(!enemiesToSend.isEmpty()){
			Enemigo e = enemiesToSend.remove(0);
			enemiesInMap.add(e);
			return e;
		}
		return null;
	}
	public void removeEnemieInMap(Enemigo e){
		enemiesInMap.remove(e);
	}
	public boolean isCompleted(){
		return (enemiesInMap.isEmpty()&&enemiesToSend.isEmpty());
	}
}