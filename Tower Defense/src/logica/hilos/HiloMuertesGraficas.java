package logica.hilos;

import grafica.entidad.*;

import java.util.ArrayList;
import java.util.List;

public class HiloMuertesGraficas extends Thread{
	protected volatile List<GraphicEntidad> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	
	public HiloMuertesGraficas(){
		execute = true;
		toDelete = new ArrayList<GraphicEntidad>();
		toExecute = new ArrayList<GraphicEntidad>();
		toInsert = new ArrayList<GraphicEntidad>();
	}
	public void agregarGrafico(GraphicEntidad g){
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
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
			int x= toExecute.size();
			for(int i=0;i<x;i++){
				toExecute.get(i).decrementarTiempoMuerte();;
				if(toExecute.get(i).getTiempoMuerte()==0)
					toDelete.add(toExecute.get(i));
			}
		}
	}
}