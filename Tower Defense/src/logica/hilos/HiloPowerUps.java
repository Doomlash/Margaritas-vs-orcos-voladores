package logica.hilos;

import logica.premio.*;

import java.util.ArrayList;
import java.util.List;

public class HiloPowerUps extends Thread{
	protected volatile List<PowerUp> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa;
	
	public HiloPowerUps(){
		execute = true;
		toDelete = new ArrayList<PowerUp>();
		toExecute = new ArrayList<PowerUp>();
		toInsert = new ArrayList<PowerUp>();
		pausa=false;
	}
	public void agregarPowerUp(PowerUp p){
		toInsert.add(p);
	}
	public void powerUpAEliminar(PowerUp p){
		toDelete.add(p);
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
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
			int x= toExecute.size();
			for(int i=0;i<x;i++){
				toExecute.get(i).reducirTemporizador();
			}
		}
	}
}