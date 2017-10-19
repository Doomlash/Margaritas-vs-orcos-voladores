package logica.hilos;

import logica.disparo.disparoEnemigo.*;
import java.util.List;
import java.util.ArrayList;

public class HiloDisparoEnemigo extends Thread{
	private List<DisparoEnemigo> toExecute, toInsert, toDelete;
	private volatile boolean execute;
	
	public HiloDisparoEnemigo(){
		execute=true;
		toDelete = new ArrayList<DisparoEnemigo>();
		toExecute = new ArrayList<DisparoEnemigo>();
		toInsert = new ArrayList<DisparoEnemigo>();
		
	}
	public void agregarDisparoEnemigo(DisparoEnemigo d){
		toInsert.add(d);
	}
	public void disparoEnemigoAEliminar(DisparoEnemigo d){
		toDelete.add(d);
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
			int x= toExecute.size();
			for(int i=0;i<x;i++){
				toExecute.get(i).ejecutar();
				try{
					Thread.sleep(150/x);
				}catch(InterruptedException e){
				}
			}
		}
	}
}