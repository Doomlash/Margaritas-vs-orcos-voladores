package logica.hilos;

import logica.entidad.enemigo.Enemigo;

import java.util.ArrayList;
import java.util.List;

public abstract class HiloEnemigo implements Runnable{
	protected volatile List<Enemigo> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	
	public HiloEnemigo(){
		execute=true;
		toDelete = new ArrayList<Enemigo>();
		toExecute = new ArrayList<Enemigo>();
		toInsert = new ArrayList<Enemigo>();
	}
	public void agregarEnemigo(Enemigo e){
		toInsert.add(e);
	}
	public void enemigoAEliminar(Enemigo e){
		toDelete.add(e);
	}
	public void terminate(){
		execute=false;
	}
	
	protected void actualizar(){
		int x= toInsert.size();
		for(int i=0;i<x;i++){
			toExecute.add(toInsert.remove(0));
		}
		int y= toDelete.size();
		for(int i=0;i<y;i++){
			toExecute.remove(toDelete.remove(0));
		}
	}
}