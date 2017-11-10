package logica.premio.magiaTemporal;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.*;
import logica.modificador_PowerUp.*;
import grafica.premio.GraphicBooster;

public class PowerBooster extends ModificadorEntidad{
	private int cd;
	private double tiempo;
	protected GraphicBooster booster;
	
	public PowerBooster(Mapa m){
		tiempo = 10;
		this.map = m;
	}
	public void actualizar(){
		tiempo=tiempo-(0.25);
		if(tiempo<=0)
			entidad.getDirector().receive(this);
	}
	
	public void afectar(Aliado a){
		this.entidad=a;
		booster = new GraphicBooster(entidad.getX(),entidad.getY(),entidad.getDimensionX(),entidad.getDimensionY());
		map.getMapaGrafico().addGraphicElemento(booster);
		cd = entidad.getCargaAtaqueNecesaria();
		entidad.setCargaAtaqueNececaria(cd/3*2);
	}
	public void afectar(Enemigo e){
		
	}
	public void restaurar(){
		entidad.setCargaAtaqueNececaria(cd);
		if(booster!=null){
			map.getMapaGrafico().removeGraphicElemento(booster);
			booster=null;
		}
	}
}