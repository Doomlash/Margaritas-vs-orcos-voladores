package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Nigromante extends Enemigo{

	public Nigromante(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		grafico = new GraphicNigromante(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void run(){
		while(execute){
				try {
					move();
				} catch (InterruptedException e) {
				}
		}
	}
}