package logica.almacen.creadorComprables.creadorAliados;

import logica.entidad.aliado.*;
import logica.mapa.Mapa;

public class CreadorSwordman extends CreadorAliado{

	public void ejecutarAccion(int x, int y, Mapa m){
		aliado = new Swordman(x,y,m);
		agregar(m);
	}
}