package logica.entidad.aliado;

import grafica.entidad.aliado.*;
import logica.mapa.*;

public class Sargento extends Aliado{
	
	public Sargento(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicSargento(x,y);
	}
}