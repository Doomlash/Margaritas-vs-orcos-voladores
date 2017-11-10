package logica.almacen.creadorComprables.creadorAliados;

import logica.entidad.aliado.*;
import logica.mapa.Mapa;

public class CreadorCaballero extends CreadorAliado{

	public void ejecutarAccion(int x, int y, Mapa m){
		aliado = new Caballero(x,y,m);
		agregar(m);
	}
}