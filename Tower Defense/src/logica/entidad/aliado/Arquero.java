package logica.entidad.aliado;

import grafica.entidad.aliado.*;
import logica.mapa.*;

public class Arquero extends Aliado{
	
	public Arquero(int x,int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicArquero(x,y);
	}
}