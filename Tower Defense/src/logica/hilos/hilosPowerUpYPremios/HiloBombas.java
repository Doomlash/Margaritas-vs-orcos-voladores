package logica.hilos.hilosPowerUpYPremios;

import logica.premio.objetoPrecioso.*;

import java.util.ArrayList;
import java.util.List;

public class HiloBombas extends Thread{
	protected volatile List<Bomba> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	
	public HiloBombas(){
		execute = true;
		toDelete = new ArrayList<Bomba>();
		toExecute = new ArrayList<Bomba>();
		toInsert = new ArrayList<Bomba>();
	}
	public void agregarBomba(Bomba b){
		toInsert.add(b);
	}
	public void bombaAEliminar(Bomba b){
		toDelete.add(b);
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
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
			int x= toExecute.size();
			for(int i=0;i<x;i++){
				toExecute.get(i).reducirTemporizador();
			}
		}
	}
}
