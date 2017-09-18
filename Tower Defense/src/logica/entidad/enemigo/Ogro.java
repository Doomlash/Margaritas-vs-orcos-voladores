package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Ogro extends Enemigo{

	public Ogro(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		grafico = new GraphicOgro(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void run(){
		while(execute){
			move();
		}
	}
	public void move(){
		
	}
}