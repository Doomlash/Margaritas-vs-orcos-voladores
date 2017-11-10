package logica.visitor.visitorEnemigo;

import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;
import logica.visitor.Visitor;

public class VisitorAtaqueEnemigo extends Visitor{
	protected Enemigo ene;
	private boolean[] filasAtacadas;
	private int fila;
	
	public VisitorAtaqueEnemigo(Enemigo e){
		ene=e;
		filasAtacadas = new boolean[ene.getDimensionY()];
		resetearFilasAtacadas();
	}
	
	public void visit(Aliado a){
		if(ene!=null){
			if(!filasAtacadas[fila-ene.getY()]){
				if(a.getX()+a.getDimensionX()==ene.getX())
					a.recibirGolpe(ene);
				if(ene!=null){
					for(int i=fila-ene.getY();(i<filasAtacadas.length)&&(i<a.getDimensionX());i++)
						filasAtacadas[i]=true;
					 ene.atacar(a);
				}
			}
		}
	}
	
	public void visit(Barricada b){
		if(ene!=null){
			if(!filasAtacadas[fila-ene.getY()]){
				ene.atacar(b);
				for(int i=fila-ene.getY();(i<filasAtacadas.length)&&(i<b.getDimensionX());i++)
					filasAtacadas[i]=true;
			}
		}
	}
	public void visit(Piedra p){
		if(ene!=null)
			if(!filasAtacadas[fila-ene.getY()]){
				ene.atacar(p);
				for(int i=fila-ene.getY();(i<filasAtacadas.length)&&(i<p.getDimensionX());i++)
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
		ene=null;
	}
}