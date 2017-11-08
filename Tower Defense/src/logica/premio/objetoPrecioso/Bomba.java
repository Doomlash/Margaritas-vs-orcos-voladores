package logica.premio.objetoPrecioso;

import logica.gameObjects.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.gameObjects.*;
import grafica.premio.*;

import java.util.List;
import java.util.ArrayList;

public class Bomba extends GameObject{
	private int damage=50;
	private int tiempo=34; //3.4 Segundos
	private List<Obstaculo> objetivos;
	
	public Bomba(int x, int y, Mapa m){
		super(x,y,1,1,m);
		grafico = new GraphicBomba(x,y);
		map.getMapaGrafico().addGraphicElemento(grafico);
		objetivos = new ArrayList<Obstaculo>();
	}
	
	public void kill(){
		map.getAlmacenHilos().getBombas().bombaAEliminar(this);
		VisitorBomba v = new VisitorBomba(this);
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				Celda c = map.getCelda(x+i, y+j);
				if(c!=null)
					c.accept(v);
			}
		}
		for(Obstaculo o: objetivos){
			o.setVida(o.getVida()-damage);
		}
	}
	public void agregarObjetivo(Obstaculo o){
		objetivos.add(o);
	}
	public void reducirTemporizador(){
		tiempo--;
		if(tiempo<=0){
			kill();
		}
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
	
}