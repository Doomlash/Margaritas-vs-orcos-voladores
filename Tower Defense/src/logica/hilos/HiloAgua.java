package logica.hilos;

import logica.mapa.elementosMapa.temporales.*;

import java.util.ArrayList;
import java.util.List;

public class HiloAgua extends Thread{
	protected volatile List<Agua> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa=false;
	
	public HiloAgua(){
		execute = true;
		toDelete = new ArrayList<Agua>();
		toExecute = new ArrayList<Agua>();
		toInsert = new ArrayList<Agua>();
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
	}
	public void agregarAgua(Agua a){
		toInsert.add(a);
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
					Thread.sleep(1000);
				}catch(InterruptedException e){
				}
				int x= toExecute.size();
				for(int i=0;i<x;i++){
					toExecute.get(i).decrementarTiempo();;
					if(toExecute.get(i).getTiempo()==0){
						toExecute.get(i).kill();
						toDelete.add(toExecute.get(i));
					}
				}
			}
		}
	}
}