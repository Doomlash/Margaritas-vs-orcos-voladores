package logica.visitor.visitorEnemigo;

import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;
import logica.mapa.elementosMapa.temporales.*;
import logica.premio.objetoPrecioso.*;
import logica.visitor.Visitor;
import logica.mapa.*;
import logica.modificador_PowerUp.*;

public class VisitorMovimientoEnemigo extends Visitor{
	private Enemigo ene;
	private Mapa map;
	private boolean ralentizado;
	
	public VisitorMovimientoEnemigo(Enemigo e, Mapa m){
		ene=e;
		this.map=m;
		ralentizado=false;
	}
	
	public void visit(Aliado a){
		if(ene!=null)
			ene.stop();
	}
	
	public void visit(Barricada b){
		if(ene!=null)
			ene.stop();
	}
	
	public void visit(Piedra p){
		if(ene!=null)
			ene.stop();
	}
	
	public void visit(Agua a){
		if(!ralentizado){
			RalentizadorAgua r = new RalentizadorAgua(map,this);
			map.getAlmacenHilos().getPowerUps().agregarPowerUp(r);
			ene.afectar(r);
			ralentizado=true;
		}
	}
	
	public void visit(Trampa t){
	}
	
	public void visit(AgujeroGusano g){
		if(ene!=null){
			ene.kill();
			g.kill();
		}
	}
	
	public void kill(){
		ene=null;
	}
	public void normal(){
		ralentizado=false;
	}

}