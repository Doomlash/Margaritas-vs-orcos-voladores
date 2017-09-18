package logica.entidad.aliado;

import grafica.entidad.aliado.*;
import logica.mapa.*;

public class Mago extends Aliado{
	
	public Mago(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicMago(x,y);
	}
}