package logica.premio.magiaTemporal;

import grafica.premio.GraphicBooster;
import logica.entidad.aliado.Aliado;
import logica.mapa.Mapa;

public class PowerBooster{
	GraphicBooster grafico;
	Mapa map;
	public PowerBooster(int x, int y, Mapa m){
		grafico=new GraphicBooster(x, y, 1, 1);
		map=m;
	}
	public void activar(Aliado aliado){
		PowerBoosterEffect efecto=new PowerBoosterEffect(aliado,map);
		efecto.start();
	}
	
	private class PowerBoosterEffect extends Thread{
		private Aliado aliado;
		private Mapa map;
		public PowerBoosterEffect(Aliado a,Mapa m){
			aliado=a;
			map=m;
		}
	    public void run(){
	        aliado.setCd(aliado.getCd()/2);
	        map.getMapaGrafico().addGraphicElemento(grafico);
	        try {
	        	Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        aliado.setCd(aliado.getCd()*2);
	        map.getMapaGrafico().removeGraphicElemento(grafico);
	    }
	}
}