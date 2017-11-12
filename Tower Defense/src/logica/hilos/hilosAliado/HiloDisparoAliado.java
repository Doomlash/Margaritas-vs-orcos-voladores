package logica.hilos.hilosAliado;

import java.util.ArrayList;
import java.util.List;

import logica.disparo.disparoAliado.*;

public class HiloDisparoAliado extends Thread{
	private List<DisparoAliado> toExecute, toInsert, toDelete;
	private volatile boolean execute;
	
	public HiloDisparoAliado(){
		execute=true;
		toDelete = new ArrayList<DisparoAliado>();
		toExecute = new ArrayList<DisparoAliado>();
		toInsert = new ArrayList<DisparoAliado>();
		
	}
	public void agregarDisparoAliado(DisparoAliado d){
		toInsert.add(d);
	}
	public void disparoAliadoAEliminar(DisparoAliado d){
		toDelete.add(d);
	}
	public void terminate(){
		execute=false;
	}
	protected void actualizar(){
		int x= toInsert.size();
		DisparoAliado d;
		for(int i=0;i<x;i++){
			d=toInsert.get(i);
			if(d.getTiempoGeneracion()==0){
				toExecute.add(toInsert.remove(i));
				x--;
			}
			else
				d.recudirTiempoGeneracion();
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
			}
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
		}
	}

}