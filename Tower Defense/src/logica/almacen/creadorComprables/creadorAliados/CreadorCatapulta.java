package logica.almacen.creadorComprables.creadorAliados;

import logica.entidad.aliado.*;
import logica.mapa.Mapa;

public class CreadorCatapulta extends CreadorAliado{
	
	public void agregar(int x, int y, Mapa m){
		aliado = new Catapulta(x,y,m);
		agregar(m);
	}
}