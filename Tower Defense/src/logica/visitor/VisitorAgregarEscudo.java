package logica.visitor;

import logica.entidad.aliado.*;
import logica.entidad.stateEscudo.*;
import logica.mapa.*;

public class VisitorAgregarEscudo extends Visitor{
	private Mapa map;
	
	public VisitorAgregarEscudo(Mapa m){
		this.map = m;
	}

	public void visit(Aliado a){
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Escudo");
		Invulnerable i = new Invulnerable(a);
		Thread t = new Thread(i);
		t.start();
		a.getEstadoEscudo().stop();
		a.setEstadoEscudo(i);
	}
	
	public void kill(){
	}

}