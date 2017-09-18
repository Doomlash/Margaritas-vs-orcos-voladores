package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Dragon extends Enemigo{

	public Dragon(int x, int y, Mapa m){
		super(x,y,2,m);
		velocidad=8;
		grafico = new GraphicDragon(x,y);
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