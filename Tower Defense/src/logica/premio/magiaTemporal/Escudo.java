package logica.premio.magiaTemporal;

import logica.entidad.Entidad;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.modificador_PowerUp.*;
import logica.entidad.stateEscudo.*;
import logica.mapa.*;
import grafica.premio.GraphicEscudo;
import grafica.entidad.*;

public class Escudo extends ModificadorEntidad{
	private double tiempo;
	protected GraphicEscudo grafico;
	
	public Escudo(Mapa m){
		tiempo=30;
		this.map=m;
	}
	public void actualizar(){
		tiempo = tiempo - 0.25;
		if(tiempo<=0)
			entidad.getDirector().receive(this);
	}
	
	public void afectar(Aliado a){
		afectarGeneral(a);
	}
	
	public void afectar(Enemigo e) {
		afectarGeneral(e);
		((GraphicEntidad)e.getGraphic()).saveEscudo(grafico);
	}
	private void afectarGeneral(Entidad e){
		this.entidad=e;
		entidad.getEstadoEscudo().kill();
		grafico = new GraphicEscudo(entidad.getX(),entidad.getY(),entidad.getDimensionX(),entidad.getDimensionY());
		map.getMapaGrafico().addGraphicElemento(grafico);
		e.setEstadoEscudo(new Invulnerable(entidad, this));
	}
	public void restaurar(){
		((GraphicEntidad)entidad.getGraphic()).saveEscudo(null);
		map.getMapaGrafico().removeGraphicElemento(grafico);
		entidad.setEstadoEscudo(new Vulnerable(entidad));
	}
	
}