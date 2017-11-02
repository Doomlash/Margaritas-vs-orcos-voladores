package logica.hilos;

import logica.entidad.aliado.*;
import java.util.ArrayList;
import java.util.List;

public class HiloAtaqueAliado extends Thread{
	protected volatile List<Aliado> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	
	public HiloAtaqueAliado(){
		execute=true;
		toDelete = new ArrayList<Aliado>();
		toExecute = new ArrayList<Aliado>();
		toInsert = new ArrayList<Aliado>();
	}
	public void agregarAliado(Aliado a){
		toInsert.add(a);
	}
	public void aliadoAEliminar(Aliado a){
		toDelete.add(a);
	}
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			int x= toInsert.size();
			for(int i=0;i<x;i++){
				toExecute.add(toInsert.remove(0));
			}
			int y= toDelete.size();
			for(int i=0;i<y;i++){
				toExecute.remove(toDelete.remove(0));
			}
			int z= toExecute.size();
			for(int i=0;i<z;i++){
				toExecute.get(i).atacarRango();
			}
			try{
				Thread.sleep(1500);
			}catch(InterruptedException e){
			}
		}
	}
}