package logica.hilos.hilosPowerUpYPremios;

import logica.modificador_PowerUp.Modificador;

import java.util.ArrayList;
import java.util.List;

public class HiloPowerUps extends Thread{
	protected volatile List<Modificador> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa=false;
	
	public HiloPowerUps(){
		execute = true;
		toDelete = new ArrayList<Modificador>();
		toExecute = new ArrayList<Modificador>();
		toInsert = new ArrayList<Modificador>();
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
	}
	public void agregarPowerUp(Modificador p){
		toInsert.add(p);
	}
	public void powerUpAEliminar(Modificador p){
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
			if(!pausa){
				try{
					Thread.sleep(250);
				}catch(InterruptedException e){
				}
				int x= toExecute.size();
				for(int i=0;i<x;i++){
					toExecute.get(i).actualizar();
				}
			}
		}
	}
}