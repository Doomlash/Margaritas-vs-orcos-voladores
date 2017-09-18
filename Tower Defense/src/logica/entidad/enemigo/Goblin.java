package logica.entidad.enemigo;

import grafica.entidad.enemigo.*;
import logica.mapa.*;

public class Goblin extends Enemigo{
	
	public Goblin(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		grafico = new GraphicGoblin(x,y,velocidad);
	}
	public void run(){
		while(execute){
			if(canMove())
				move();
		}
	}
	public void move(){
		if(x-1>=0){
			map.getCelda(x-1, y).agregarElemento(this);
			map.getCelda(x, y).deleteElemento(this);
		}
	}
}