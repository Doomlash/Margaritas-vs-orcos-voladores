package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Nigromante extends Enemigo{

	public Nigromante(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		grafico = new GraphicNigromante(x,y);
	}
	public void run(){
		while(execute){
			move();
		}
	}
	public void move(){
		
	}
}