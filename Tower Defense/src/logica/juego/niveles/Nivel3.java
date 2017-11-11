package logica.juego.niveles;

import java.util.Random;

import logica.entidad.enemigo.*;
import logica.juego.*;

public class Nivel3 extends Nivel{
	
	public Nivel3(Juego j){
		super(j);
		for(int i=0;i<hordas.length;i++)
			hordas[i].setTiempoCreacional(3);
		crearHordas();
	}
	
	public void crearHordas(){
		Enemigo e;
		Random r = new Random();
		int aux;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				aux = r.nextInt(5);
				e = new Cerberus(map.getCeldas()[0].length-1,aux,map);
				hordas[i].agregar(e);
			}
		}
	}
	
	public Nivel getSiguiente(){
		map.clear();
		map.getAlmacenHilos().terminateAll();
		juego.getGui().getPanelPrincipal().remove(map.getMapaGrafico());
		juego.getGui().getPanelPrincipal().repaint();
		return null;
	}
}