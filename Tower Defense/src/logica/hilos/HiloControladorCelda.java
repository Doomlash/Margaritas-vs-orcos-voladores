package logica.hilos;

import logica.gameObjects.*;
import logica.mapa.*;

import java.util.ArrayList;
import java.util.List;

public class HiloControladorCelda extends Thread{
	protected volatile List<Elemento> toDelete,toInsert;
	protected volatile boolean execute;
	protected Celda celda;
	
	public HiloControladorCelda(Celda c){
		execute = true;
		this.celda=c;
		toDelete = new ArrayList<Elemento>();
		toInsert = new ArrayList<Elemento>();
	}
	public void agregarElemento(Elemento e){
		toInsert.add(e);
	}
	public void elementoAEliminar(Elemento e){
		toDelete.add(e);
	}
	public void terminate(){
		execute=false;
	}
	protected void actualizar(){
		int x= toInsert.size();
//		for(int i=0;i<x;i++){
//			toExecute.add(toInsert.remove(0));
//		}
//		int y= toDelete.size();
//		for(int i=0;i<y;i++){
//			toExecute.remove(toDelete.remove(0));
//		}
	}
	public void run(){
		while(execute){
			actualizar();
//			celda.actualizada();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
		}
	}
}