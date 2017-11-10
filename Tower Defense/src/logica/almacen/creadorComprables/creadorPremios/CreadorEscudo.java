package logica.almacen.creadorComprables.creadorPremios;

import logica.almacen.*;
import logica.mapa.Mapa;
import logica.visitor.visitorPowerUpYPremios.VisitorAgregarEscudo;
import logica.premio.magiaTemporal.*;

public class CreadorEscudo implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		Escudo e = new Escudo(m);
		if(!m.getCelda(x, y).isEmpty()){
			m.getCelda(x, y).getFirst().accept(new VisitorAgregarEscudo(m,e));;
		}
	}

}