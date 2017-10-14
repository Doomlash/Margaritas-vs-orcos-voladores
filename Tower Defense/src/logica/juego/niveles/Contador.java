package logica.juego.niveles;

import logica.entidad.enemigo.Enemigo;

public class Contador extends Thread{
	private Nivel n;
	private volatile boolean execute;
	
	public Contador(Nivel n){
		this.n=n;
	}
	
	public void terminate(){
		execute=false;
	}
	
	public void run(){
		while(execute){
			Horda h = this.n.getHordaActual();
				Enemigo e= h.getSiguienteIntermedio();
				if(e!=null){
					try{
						Thread.sleep(4000);
					}catch(InterruptedException e1){
					}
				}
				else{
					e= h.getSiguienteFinal();
					if(e!=null){
						try{
							Thread.sleep(2000);
						}catch(InterruptedException e1){
						}
					}
				}
		}
	}
}