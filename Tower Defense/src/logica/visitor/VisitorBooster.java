package logica.visitor;

import logica.mapa.*;
import logica.entidad.aliado.Aliado;
import logica.premio.magiaTemporal.*;

public class VisitorBooster extends Visitor{
	private Mapa map;
	
	public VisitorBooster(Mapa m){
		this.map=m;
	}
	public void visit(Aliado a){
		map.getAlmacenHilos().getPowerUps().agregarPowerUp(new PowerBooster(a,map));
	}
	
	public void kill(){}

}