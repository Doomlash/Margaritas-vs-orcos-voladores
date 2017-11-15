package logica.hilos.hilosPowerUpYPremios;

import grafica.premio.*;

import java.util.ArrayList;
import java.util.List;

public class HiloTrampas extends Thread{
	protected volatile List<GraphicTrampa> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa=false;
	
	public HiloTrampas(){
		execute = true;
		toDelete = new ArrayList<GraphicTrampa>();
		toExecute = new ArrayList<GraphicTrampa>();
		toInsert = new ArrayList<GraphicTrampa>();
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
	}
	public void agregarGrafico(GraphicTrampa g){
		toInsert.add(g);
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
					Thread.sleep(100);
				}catch(InterruptedException e){
				}
				int x= toExecute.size();
				for(int i=0;i<x;i++){
					toExecute.get(i).decrementarTiempoAccionar();;
					if(toExecute.get(i).getTiempoAccionar()==0)
						toDelete.add(toExecute.get(i));
				}
			}
		}
	}
}
