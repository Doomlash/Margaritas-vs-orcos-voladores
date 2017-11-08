package logica.visitor;

import logica.entidad.aliado.*;
import logica.mapa.*;
import logica.premio.magiaTemporal.*;

public class VisitorAgregarEscudo extends Visitor{
	private Mapa map;
	private Escudo escudo;
	
	public VisitorAgregarEscudo(Mapa m, Escudo e){
		this.map = m;
		this.escudo=e;
	}

	public void visit(Aliado a){
		map.getAlmacenHilos().getPowerUps().agregarPowerUp(escudo);
		a.afectar(escudo);
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Escudo");
	}
	
	public void kill(){
	}

}