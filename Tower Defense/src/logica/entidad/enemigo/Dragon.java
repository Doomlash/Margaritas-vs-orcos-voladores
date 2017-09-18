package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Dragon extends Enemigo{

	public Dragon(int x, int y, Mapa m){
		super(x,y,2,m);
		velocidad=8;
		grafico = new GraphicDragon(x,y,velocidad);
	}
	public void run(){
		while(execute){
			move();
		}
	}
	public void move(){
		
	}
}