package logica.visitor;

import logica.mapa.*;
import logica.entidad.aliado.Aliado;
import logica.premio.magiaTemporal.*;

public class VisitorBooster extends Visitor{
	private Mapa map;
	private PowerBooster booster;
	
	public VisitorBooster(Mapa m, PowerBooster b){
		this.map=m;
		this.booster=b;
	}
	public void visit(Aliado a){
		map.getAlmacenHilos().getPowerUps().agregarPowerUp(booster);
		a.afectar(booster);
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Booster");
	}
	
	public void kill(){}

}