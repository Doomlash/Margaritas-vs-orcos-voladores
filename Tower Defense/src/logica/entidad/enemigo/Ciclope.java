package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Ciclope extends Enemigo{

	public Ciclope(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		grafico = new GraphicCiclope(x,y);
	}
	public void run(){
		while(execute){
			move();
		}
	}
	public void move(){
		
	}
}