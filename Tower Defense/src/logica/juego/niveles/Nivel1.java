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
		Enemigo e;
		Random r = new Random();
		int aux;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				aux = r.nextInt(5);
				e = new Dragon(11,aux,map);
				hordas[i].agregar(e);
			}
		}
	}
	
	public Nivel getSiguiente(){
		return new Nivel2(juego);
	}
}