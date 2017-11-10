package logica.almacen.creadorComprables.creadorAliados;

import logica.mapa.*;
import logica.entidad.aliado.*;

public class CreadorArquero extends CreadorAliado{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		aliado = new Arquero(x,y,m);
		agregar(m);
	}
}