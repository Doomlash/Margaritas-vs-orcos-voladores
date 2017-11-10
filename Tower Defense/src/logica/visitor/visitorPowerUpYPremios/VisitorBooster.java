package logica.visitor.visitorPowerUpYPremios;

import logica.mapa.*;
import logica.entidad.aliado.Aliado;
import logica.premio.magiaTemporal.*;
import logica.visitor.Visitor;

public class VisitorBooster extends Visitor{
	private Mapa map;
	private PowerBooster booster;
	
	public VisitorBooster(Mapa m, PowerBooster b){
		this.map=m;
		this.booster=b;
	}
	public void visit(Aliado a){
		map.getAlmacenHilos().getPowerUps().agregarPowerUp(booster);
		a.getDirector().receive(booster);
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().disminuirCantidad("Booster");
	}
	
	public void kill(){}

}