package logica.modificador_PowerUp;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.visitor.*;
import logica.visitor.visitorEnemigo.VisitorMovimientoEnemigo;
import logica.mapa.*;

public class RalentizadorAgua extends Modificador{
	private int velocidadAlmacenada;
	private int posicionAlmacenada;
	private VisitorMovimientoEnemigo visitor;
	
	public RalentizadorAgua(Mapa m, VisitorMovimientoEnemigo v){
		this.map=m;
		this.visitor=v;
	}
	public void actualizar(){
		if(entidad.getX()!=posicionAlmacenada)
			kill();
	}
	public void afectar(Aliado a){
		
	}
	public void restaurar(){
		((Enemigo)entidad).setVelocidad(velocidadAlmacenada);
		visitor.normal();
	}
	public void afectar(Enemigo e){
		this.entidad=e;
		posicionAlmacenada=e.getX();
		velocidadAlmacenada=e.getVelocidad();
		e.setVelocidad(velocidadAlmacenada/2);
	}
}