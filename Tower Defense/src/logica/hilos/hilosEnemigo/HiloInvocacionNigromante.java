package logica.hilos.hilosEnemigo;

import logica.entidad.enemigo.Nigromante;

import java.util.ArrayList;
import java.util.List;

public class HiloInvocacionNigromante extends Thread{
	protected volatile List<Nigromante> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa;
	
	public HiloInvocacionNigromante(){
		execute = true;
		toDelete = new ArrayList<Nigromante>();
		toExecute = new ArrayList<Nigromante>();
		toInsert = new ArrayList<Nigromante>();
		pausa = false;
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
	}
	public void agregarNigromante(Nigromante n){
		toInsert.add(n);
	}
	public void nigromanteAEliminar(Nigromante n){
		toDelete.add(n);
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
				int x= toExecute.size();
				for(int i=0;i<x;i++){
//					toExecute.get(i).invocar();
				}
				try{
					Thread.sleep(50);
				}catch(InterruptedException e){
				}
			}
		}
	}
}