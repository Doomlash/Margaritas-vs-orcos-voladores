package logica.entidad.enemigo;

import logica.entidad.*;
import logica.gameObjects.Elemento;

import java.util.List;

import logica.Visitor.VisitorColisiones.*;
import logica.Visitor.VisitorInteraccion.*;

public abstract class Enemigo extends Entidad{
	protected int velocidad;
	protected int puntaje;
	protected int monedas;
	
	public Enemigo(){
		
	}

	public Elemento chequearColision(int k, int f){
		List<Elemento> list = null;
		Elemento ele;
		int pos=0;
		boolean hayColision= false;
		for(int i=k;(i>=f)&&(!hayColision);i--){
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
}
