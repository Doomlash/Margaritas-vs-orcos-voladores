package logica.almacen.creadorComprables.creadorPremios;

import logica.almacen.*;
import logica.mapa.Mapa;
import logica.visitor.*;

public class CreadorEscudo implements Creador{
	
	public void agregar(int x, int y, Mapa m){
		System.out.println("En creador escudo");
		if(!m.getCelda(x, y).isEmpty()){
			m.getCelda(x, y).getFirst().accept(new VisitorAgregarEscudo(m));;
		}
	}

}