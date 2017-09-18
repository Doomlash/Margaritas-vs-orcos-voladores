package logica.entidad.aliado;

import logica.mapa.Mapa;
import grafica.entidad.aliado.*;

public class Catapulta extends Aliado{
	
	public Catapulta(int x, int y, Mapa m){
		super(x,y,2,m);
		grafico = new GraphicCatapulta(x,y);
	}
}