package logica.visitor.visitorPowerUpYPremios;

import logica.visitor.*;
import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.mapa.elementosMapa.destruibles.*;

public class VisitorCuracion extends Visitor{
	private CampoDeCuracion curacion;
	
	public VisitorCuracion(CampoDeCuracion c){
		curacion=c;
	}
	public void visit(Aliado a){
		if(curacion!=null)
			a.setVida(a.getVida()+a.getVidaMax()*curacion.getPorcentaje()/100);
	}
	public void visit(Barricada b){
		if(curacion!=null)
			b.setVida(b.getVida()+b.getVidaMax()*curacion.getPorcentaje()/100);
	}
	public void visit(Piedra p){
		if(curacion!=null)
			p.setVida(p.getVida()+p.getVidaMax()*curacion.getPorcentaje()/100);
	}
	
	public void kill(){
		curacion=null;
	}
}