package logica.hilos;

import logica.itemPremio.*;

import java.util.ArrayList;
import java.util.List;

public class HiloItemsPremio extends Thread{
	protected volatile List<ItemPremio> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	
	public HiloItemsPremio(){
		execute=true;
		toDelete = new ArrayList<ItemPremio>();
		toExecute = new ArrayList<ItemPremio>();
		toInsert = new ArrayList<ItemPremio>();
	}
	public void agregarItem(ItemPremio i){
		toInsert.add(i);
	}
	public void itemAEliminar(ItemPremio i){
		toDelete.add(i);
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
				toExecute.get(i).reducirTiempo();
			}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
		}
	}
}
