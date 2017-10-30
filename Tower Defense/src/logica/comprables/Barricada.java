package logica.comprables;

import logica.mapa.*;
import logica.visitor.*;
import logica.gameObjects.*;
import grafica.gameObjects.*;
import grafica.comprables.*;

public class Barricada extends Obstaculo implements Comprable{
	private int precio;
	private GraphicBarricada grafico;

	public Barricada(int x,int y, Mapa m){
		super(x,y,1,m);
		precio = 20;
		vida=vidaMax=100;
		grafico = new GraphicBarricada(x,y);
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	public void setVida(int v){
		if(vida>vidaMax/3*2)
			grafico.restaurar();
		else
			if((vida>vidaMax/3)&&(vida<=(vidaMax/3*2)))
				grafico.deterioro();
			else
				if((vida>0)&&(vida<vidaMax/3))
					grafico.dobleDeterioro();
		super.setVida(v);
	}
	
	public int getPrecio(){
		return precio;
	}
	
	public void kill(){
		map.eliminarElemento(this);
	}
	
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}