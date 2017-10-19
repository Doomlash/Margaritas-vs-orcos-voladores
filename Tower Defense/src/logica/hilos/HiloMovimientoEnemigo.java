package logica.hilos;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class HiloMovimientoEnemigo extends Thread{
	protected volatile List<Enemigo> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	
	public HiloMovimientoEnemigo(){
		execute = true;
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
			toExecute.add(toInsert.remove(i));
		}
		int y= toDelete.size();
		for(int i=0;i<y;i++){
			toExecute.remove(toDelete.remove(i));
		}
	}
	public void run(){
		while(execute){
			actualizar();
			int x= toExecute.size();
			for(int i=0;i<x;i++){
				toExecute.get(i).move();
				try{
					Thread.sleep(150/x);
				}catch(InterruptedException e){
				}
			}
		}
	}
}