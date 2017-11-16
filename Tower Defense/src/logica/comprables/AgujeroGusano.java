package logica.comprables;

import logica.gameObjects.*;
import logica.visitor.*;
import logica.mapa.*;
import grafica.comprables.*;

public class AgujeroGusano extends Elemento implements Comprable{
	private int precio;
	
	public AgujeroGusano(int x, int y, Mapa m){
		super(x,y,1,1,m);
		precio = 500;
		grafico = new GraphicAgujeroGusano(x,y);
	}
	
	public int getPrecio(){
		return precio;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public void kill(){
		map.eliminarElemento(this);
	}
}