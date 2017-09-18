package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Lich extends Enemigo{

	public Lich(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		grafico = new GraphicLich(x,y);
	}
	public void run(){
		while(execute){
			move();
		}
	}
	public void move(){
		
	}
}