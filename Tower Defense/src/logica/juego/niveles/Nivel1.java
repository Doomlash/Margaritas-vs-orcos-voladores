package logica.juego.niveles;

import logica.entidad.enemigo.*;
import logica.juego.*;

import java.util.Random;

public class Nivel1 extends Nivel{
	
	public Nivel1(Juego j){
		super(j);
	}
	
	public void crearHordas(){

		Random r = new Random();
		int aux;
		for(int i=0;i<3;i++){
			aux = r.nextInt(6);
			hordas[0].agregarIntermedio(new Goblin(10,aux,map));
			aux = r.nextInt(6);
			hordas[1].agregarIntermedio(new Goblin(10,aux,map));
			aux = r.nextInt(6);
			hordas[2].agregarIntermedio(new Goblin(10,aux,map));
		}
		for(int i=0;i<5;i++){
			aux = r.nextInt(6);
			hordas[0].agregarFinal(new Goblin(10,aux,map));
			aux = r.nextInt(6);
			hordas[1].agregarFinal(new Goblin(10,aux,map));
			aux = r.nextInt(6);
			hordas[2].agregarFinal(new Goblin(10,aux,map));
		}
	}
	
	public Nivel getSiguiente(){
		return new Nivel2(juego);
	}
}