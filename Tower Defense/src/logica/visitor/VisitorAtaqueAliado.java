package logica.visitor;

import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.mapa.elementosMapa.destruibles.Piedra;

public class VisitorAtaqueAliado extends Visitor{
	protected  Aliado aliado;
	
	public VisitorAtaqueAliado(Aliado a){
		aliado=a;
	}
	
	public void visit(Enemigo e){
		if(aliado!=null){
			if(aliado.getX()+aliado.getDimensionX()==e.getX())
				e.recibirGolpe(aliado);
			if(aliado!=null)
				aliado.atacar(e);
		}
	}
	public void visit(Piedra p){
		if(aliado!=null)
			aliado.atacar(p);
	}
	
	public void kill(){
		aliado=null;
	}
}
