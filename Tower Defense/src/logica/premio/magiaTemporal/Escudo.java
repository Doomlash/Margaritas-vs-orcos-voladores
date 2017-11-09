package logica.premio.magiaTemporal;

import logica.entidad.Entidad;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.modificador_PowerUp.*;
import logica.entidad.stateEscudo.*;
import logica.mapa.*;
import grafica.entidad.*;

public class Escudo extends Modificador{
	private double tiempo;
	
	public Escudo(Mapa m){
		tiempo=10;
		this.map=m;
	}
	public void actualizar(){
		tiempo = tiempo - 0.25;
		if(tiempo<=0)
			kill();
	}
	
	public void afectar(Aliado a){
		afectarGeneral(a);
	}
	
	public void afectar(Enemigo e) {
		afectarGeneral(e);
	}
	private void afectarGeneral(Entidad e){
		this.entidad=e;
		entidad.getEstadoEscudo().kill();
		((GraphicEntidad)entidad.getGraphic()).desactivarEscudo();
		e.setEstadoEscudo(new Invulnerable(entidad, this));
		((GraphicEntidad)entidad.getGraphic()).activarEscudo(entidad.getX(), entidad.getY(), entidad.getDimensionX(), entidad.getDimensionY());
	}
	public void restaurar(){
		((GraphicEntidad)entidad.getGraphic()).desactivarEscudo();
		entidad.setEstadoEscudo(new Vulnerable(entidad));
	}
	
}