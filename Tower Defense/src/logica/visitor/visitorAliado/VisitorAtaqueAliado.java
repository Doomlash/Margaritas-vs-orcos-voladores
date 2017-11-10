package logica.visitor.visitorAliado;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;
import logica.visitor.*;

public class VisitorAtaqueAliado extends Visitor{
	protected Aliado aliado;
	private boolean[] filasAtacadas;
	private int fila;
	
	public VisitorAtaqueAliado(Aliado a){
		aliado=a;
		filasAtacadas = new boolean[aliado.getDimensionY()];
		resetearFilasAtacadas();
	}
	
	public void visit(Enemigo e){
		if(aliado!=null){
			if(!filasAtacadas[fila-aliado.getY()]){
				if(aliado.getX()+aliado.getDimensionX()==e.getX())
					e.recibirGolpe(aliado);
				if(aliado!=null){
					for(int i=fila-aliado.getY();(i<filasAtacadas.length)&&(i<e.getDimensionX());i++)
						filasAtacadas[i]=true;
					aliado.atacar(e);
				}
			}
		}

	}
	public void visit(Piedra p){
		if(aliado!=null)
			if(!filasAtacadas[fila-aliado.getY()]){
				aliado.atacar(p);
				for(int i=fila-aliado.getY();(i<filasAtacadas.length)&&(i<p.getDimensionX());i++)
					filasAtacadas[i]=true;
		}
	}
	public void filaActualAtacada(int y){
		fila=y;
	}
	public void resetearFilasAtacadas(){
		for(int i=0;i<filasAtacadas.length;i++)
			filasAtacadas[i]=false;
	}
	
	public void kill(){
		aliado=null;
	}
}
