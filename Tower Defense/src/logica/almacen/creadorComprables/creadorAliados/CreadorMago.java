package logica.almacen.creadorComprables.creadorAliados;

import logica.entidad.aliado.*;
import logica.mapa.Mapa;

public class CreadorMago extends CreadorAliado{
	
	public void agregar(int x, int y, Mapa m){
		aliado = new Mago(x,y,m);
		agregar(m);
	}
}