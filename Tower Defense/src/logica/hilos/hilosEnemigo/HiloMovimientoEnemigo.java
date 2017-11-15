package logica.hilos.hilosEnemigo;

import logica.entidad.enemigo.*;
import grafica.entidad.enemigo.*;

import java.util.List;
import java.util.ArrayList;

public class HiloMovimientoEnemigo extends Thread{
	protected volatile List<Enemigo> toDelete,toExecute,toInsert;
	protected volatile boolean execute;
	protected boolean pausa;
	protected boolean congelado=false;
	
	public HiloMovimientoEnemigo(){
		execute = true;
		toDelete = new ArrayList<Enemigo>();
		toExecute = new ArrayList<Enemigo>();
		toInsert = new ArrayList<Enemigo>();
		pausa=false;
	}
	public void congelar(){
		congelado=true;
		int x = toExecute.size();
		for(int i=0;i<x;i++)
			((GraphicEnemigo)toExecute.get(i).getGraphic()).congelar();
	}
	public void descongelar(){
		congelado=false;
	}
	public void pausar(){
		pausa=true;
		int x = toExecute.size();
		for(int i=0;i<x;i++)
			toExecute.get(i).getGraphic().setImageIdle();
	}
	public void reanudar(){
		pausa=false;
	}
	public void agregarEnemigo(Enemigo e){
		toInsert.add(e);
	}
	public void enemigoAEliminar(Enemigo e){
		toDelete.add(e);
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
			if(!pausa&&!congelado){
				int x= toExecute.size();
				for(int i=0;i<x;i++){
					toExecute.get(i).move();
				}
				try{
					Thread.sleep(180);
				}catch(InterruptedException e){
				}
			}
			if(congelado){
				int x= toExecute.size();
				for(int i=0;i<x;i++)
					((GraphicEnemigo)toExecute.get(i).getGraphic()).congelar();
			}
		}
	}
}