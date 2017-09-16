package logica.entidad.aliado;

import logica.entidad.*;
import logica.gameObjects.*;
import logica.Visitor.VisitorColisiones.VisitorColision;
import logica.Visitor.VisitorInteraccion.*;
import logica.comprables.*;
import logica.premio.magiaTemporal.*;

import java.util.List;

public abstract class Aliado extends Entidad implements  Comprable{
	protected int precio;
	protected CabezaDeDragon dragon;
	protected PowerBooster booster;
	
	public Aliado(){
	}
	
	public void accept(VisitorInteraccion v){
		v.visit(this);
	}
	
	public int getPrecio(){
		return precio;
	}
	public boolean accept(VisitorColision v){
		return v.visit(this);
	}
	public boolean accept(CabezaDeDragon c){
		dragon=c;
		return true;
	}
	
	public Elemento chequearColision(int k, int f){
		List<Elemento> list = null;
		Elemento ele;
		int pos=0;
		boolean hayColision= false;
		for(int i=k;(i<=f)&&(!hayColision);i++){
			list=map.getCelda(i, y).getElementos();
			if(!list.isEmpty()){
				ele=list.get(pos);
				while((pos<list.size())&&(!hayColision)){
					hayColision= ele.accept(visitorColision);
					pos++;
					ele=list.get(pos);
				}
			}
		}
		if(hayColision)
			return list.get(pos-1);
		else return null;
	}
	public void atacar(){
		Elemento ele= chequearColision(x[x.length-1],x[x.length-1]+rango);
		if(ele!=null)
			ele.accept(visitorAtaque);
	}
}