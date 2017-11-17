package logica.juego.niveles;

import java.util.Random;

import logica.entidad.enemigo.*;
import logica.juego.*;

public class Nivel3 extends Nivel{
	
	public Nivel3(Juego j){
		super(j);
		presupuesto= 1800;
		for(int i=0;i<hordas.length;i++)
			hordas[i].setTiempoCreacional(3);
		crearHordas();
	}
	
	public void crearHordas(){
		Random r = new Random();
		int aux;

		//Horda1
		for(int i=0;i<5;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[0].agregar(new Goblin(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<2;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[0].agregar(new Ogro(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<3;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[0].agregar(new Lich(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<2;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[0].agregar(new Nigromante(map.getCeldas()[0].length-1,aux,map));
		}
		
		//Horda2
		for(int i=0;i<3;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[1].agregar(new Goblin(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<4;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[1].agregar(new Ciclope(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<2;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[1].agregar(new Lich(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<2;i++){
			aux = r.nextInt(map.getCeldas().length-3);
			hordas[1].agregar(new Dragon(map.getCeldas()[0].length-1,aux,map));
		}
		
		
		//Horda3
		for(int i=0;i<7;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[2].agregar(new Goblin(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<4;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[2].agregar(new Ciclope(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<2;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[2].agregar(new Lich(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<2;i++){
			aux = r.nextInt(map.getCeldas().length-1);
			hordas[2].agregar(new Nigromante(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<3;i++){
			aux = r.nextInt(map.getCeldas().length-3);
			hordas[2].agregar(new Dragon(map.getCeldas()[0].length-1,aux,map));
		}
		for(int i=0;i<3;i++){
			aux = r.nextInt(map.getCeldas().length-3);
			hordas[2].agregar(new Cerberus(map.getCeldas()[0].length-1,aux,map));
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