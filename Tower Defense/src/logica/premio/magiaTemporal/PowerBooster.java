package logica.premio.magiaTemporal;

import logica.entidad.aliado.Aliado;

public class PowerBooster{
	
	public void activar(Aliado aliado){
		PowerBoosterEffect efecto=new PowerBoosterEffect(aliado);
		efecto.start();
	}
	
	private class PowerBoosterEffect extends Thread{
		private Aliado aliado;
		public PowerBoosterEffect(Aliado a){
			aliado=a;
		}
	    public void run(){
	    	//int cdInicial=aliado.getCd();
	        aliado.setCd(aliado.getCd()/2);
	        try {
	        	Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        aliado.setCd(aliado.getCd()*2);
	    }
	}
}