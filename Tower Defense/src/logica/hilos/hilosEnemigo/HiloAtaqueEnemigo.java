package logica.hilos.hilosEnemigo;

import logica.entidad.enemigo.*;
import java.util.List;
import java.util.ArrayList;

public class HiloAtaqueEnemigo extends Thread{
	protected volatile List<Enemigo> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa=false;
	
	public HiloAtaqueEnemigo(){
		execute = true;
		toDelete = new ArrayList<Enemigo>();
		toExecute = new ArrayList<Enemigo>();
		toInsert = new ArrayList<Enemigo>();
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
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
	public void run(){
		while(execute){
			actualizar();
			if(!pausa){
				int x= toExecute.size();
				for(int i=0;i<x;i++){
					toExecute.get(i).atacarRango();
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
				}
			}
		}
	}
}