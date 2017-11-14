package logica.juego.niveles;

import logica.entidad.enemigo.*;
import logica.juego.*;

import java.util.Random;

public class Nivel1 extends Nivel{
	
	public Nivel1(Juego j){
		super(j);
		for(int i=0;i<hordas.length;i++)
			hordas[i].setTiempoCreacional(3);
		crearHordas();
	}
	
	public void crearHordas(){
		Random r = new Random();
		int aux;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				aux = r.nextInt(5);
				hordas[i].agregar(new Goblin(map.getCeldas()[0].length-1,aux,map));
			}
			aux = r.nextInt(5);
			hordas[i].agregar(new Lich(map.getCeldas()[0].length-1,aux,map));
			hordas[i].agregar(new Nigromante(map.getCeldas()[0].length-1,aux,map));
		}
	}
	
	public Nivel getSiguiente(){
		map.clear();
		map.getAlmacenHilos().terminateAll();
		juego.getGui().getPanelPrincipal().remove(map.getMapaGrafico());
		juego.getGui().getPanelPrincipal().repaint();
		return new Nivel2(juego);
	}
}