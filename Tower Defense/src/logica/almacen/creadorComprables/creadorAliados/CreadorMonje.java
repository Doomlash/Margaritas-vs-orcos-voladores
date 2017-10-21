package logica.almacen.creadorComprables.creadorAliados;

import logica.entidad.aliado.*;
import logica.mapa.Mapa;

public class CreadorMonje extends CreadorAliado{
	
	public void agregar(int x, int y, Mapa m){
		aliado = new Monje(x,y,m);
		agregar(m);
	}
}