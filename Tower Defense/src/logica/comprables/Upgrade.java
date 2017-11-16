package logica.comprables;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.modificador_PowerUp.*;
import logica.mapa.*;
import grafica.entidad.*;

public class Upgrade extends ModificadorEntidad implements Comprable{
	private int precio;
	private double tiempo;
	private int vidaMaxSaved,fuerzaSaved;
	
	public Upgrade(Mapa m){
		this.map=m;
		precio=200;
		tiempo=30;
	}
	public int getPrecio(){
		return precio;
	}
	
	public void actualizar(){
		tiempo = tiempo - 0.25;
		if(tiempo<=0)
			entidad.getDirector().receive(this);		
	}

	public void afectar(Aliado a){
		entidad=a;
		vidaMaxSaved=a.getVidaMax();
		a.setVidaMax(vidaMaxSaved*2);
		a.setVida(vidaMaxSaved*2);
		fuerzaSaved=a.getFuerza();
		a.setFuerza(fuerzaSaved+fuerzaSaved/2);
		((GraphicEntidad)a.getGraphic()).upgrade();
		map.getAlmacenHilos().getPowerUps().agregarPowerUp(this);
	}
	public void afectar(Enemigo e){
		
	}
	public void restaurar(){
		if(tiempo<=0){
			entidad.setVida(vidaMaxSaved);
			entidad.setVidaMax(vidaMaxSaved);
		}
		entidad.setFuerza(fuerzaSaved);
		((GraphicEntidad)entidad.getGraphic()).downgrade();
		((GraphicEntidad)entidad.getGraphic()).actualizarLifeLine(entidad.getVidaMax(), entidad.getVida());;
	}
}
