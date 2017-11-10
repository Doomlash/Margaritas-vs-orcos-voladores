package logica.hilos;

import logica.juego.niveles.*;

public class Contador extends Thread{
	private Nivel nivel;
	private int tiempo, contadorGeneral;
	private volatile boolean execute;
	
	public Contador(Nivel n){
		this.nivel=n;
		execute=true;
		tiempo=0;
		contadorGeneral=0;
	}
	
	public void run(){
		while(execute){
			Horda h = nivel.getHordaActual();
			System.out.println(h);
			if(h==null)
				nivel.getJuego().siguienteNivel();
			else{
				if(h.isEmpty())
					nivel.siguienteHorda();
				else{
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
					}
					contadorGeneral++;
					tiempo++;
					if(nivel.getHordaActual().getTiempoCreacional()==tiempo){
						tiempo=0;
						nivel.getMapa().agregarElemento(nivel.getHordaActual().getSiguiente());				
					}
				}
			}
		}
	}
}