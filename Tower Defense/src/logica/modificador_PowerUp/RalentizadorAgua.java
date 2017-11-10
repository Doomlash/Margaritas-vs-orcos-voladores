package logica.modificador_PowerUp;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.*;

public class RalentizadorAgua extends ModificadorEntidad{
	private int velocidadAlmacenada;
	private int posicionAlmacenada;
	
	public RalentizadorAgua(Mapa m){
		this.map=m;
	}
	public void actualizar(){
		if(entidad.getX()!=posicionAlmacenada)
			entidad.getDirector().receive(this);
	}
	public void afectar(Aliado a){
		
	}
	public void restaurar(){
		((Enemigo)entidad).setVelocidad(velocidadAlmacenada);
	}
	public void afectar(Enemigo e){
		map.getAlmacenHilos().getPowerUps().agregarPowerUp(this);
		this.entidad=e;
		posicionAlmacenada=e.getX();
		velocidadAlmacenada=e.getVelocidad();
		e.setVelocidad(velocidadAlmacenada/2);
	}
}