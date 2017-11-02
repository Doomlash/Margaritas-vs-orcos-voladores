package logica.entidad.stateEscudo;

import logica.entidad.*;
import logica.disparo.*;

public class Invulnerable extends EstadoEscudo implements Runnable{
	private Entidad entidad;
	private int tiempo = 10; //10 segundos de duración
	private volatile boolean execute;
	
	public Invulnerable(Entidad e){
		this.entidad=e;
		execute = true;
	}
	
	public void run(){
		while(execute){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
			tiempo--;
			if(tiempo<=0)
				kill();
		}
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
	public void kill(){
		execute = false;
		this.entidad.setEstadoEscudo(new Vulnerable());
	}
}