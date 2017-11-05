package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;
import logica.premio.objetoPrecioso.*;
import grafica.entidad.*;

public class Invulnerable extends EstadoEscudo implements Runnable{
	private int tiempo = 10; //10 segundos de duración
	private volatile boolean execute;
	
	public Invulnerable(Entidad e){
		this.entidad=e;
		((GraphicEntidad)entidad.getGraphic()).activarEscudo(entidad.getX(), entidad.getY(),entidad.getDimensionX());
		execute = true;
	}
	
	public void run(){
		while(execute){
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
			}
			if(execute)
				try{
					Thread.sleep(250);
				}catch(InterruptedException e){
				}
			if(execute)
				try{
					Thread.sleep(250);
				}catch(InterruptedException e){
				}
			if(execute)
				try{
					Thread.sleep(250);
				}catch(InterruptedException e){
				}
			tiempo--;
			if(tiempo<=0)
				kill();
		}
		kill();
	}
	public void stop(){
		execute=false;
	}
	public void recibirGolpe(Entidad e){
		e.kill();
		kill();
	}
	public void recibirGolpe(Disparo d){
		d.kill();
	}
	public void recibirGolpe(Bomba b){
		
	}
	public void kill(){
		execute = false;
		this.entidad.setEstadoEscudo(new Vulnerable(entidad));
		((GraphicEntidad)entidad.getGraphic()).desactivarEscudo();
	}
}