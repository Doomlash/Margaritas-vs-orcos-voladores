package logica.visitor;

import logica.entidad.enemigo.*;
import logica.premio.objetoPrecioso.*;
import logica.mapa.*;

public class VisitorCeldaEsqueleto extends Visitor{
	private Nigromante n;
	private Mapa map;
	private int x,y;
	
	public VisitorCeldaEsqueleto(Nigromante n, Mapa m){
		this.n=n;
		this.map=m;
	}
	public void actualizarCeldaDeCreacion(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void visit(Enemigo e){
		if(n!=null)
			n.agregarEsqueleto(new Esqueleto(x,y,map,n));
	}
	public void visit(Trampa t){
		if(n!=null)
			n.agregarEsqueleto(new Esqueleto(x,y,map,n));
	}
	public void kill(){
		n=null;
	}
}