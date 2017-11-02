package logica.premio.objetoPrecioso;

import logica.gameObjects.*;
import logica.mapa.*;
import logica.visitor.VisitorBomba;
import grafica.gameObjects.*;
import grafica.premio.*;

public class Bomba extends GameObject implements Runnable{
	private GraphicBomba grafico;
	
	public Bomba(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicBomba(x,y);
	}
	
	public void kill(){
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				Celda celda=map.getCelda(x+i,y+j);
				for(Elemento e:celda.getElementos()){
					e.accept(new VisitorBomba());
				}
			}
		}
		map.getMapaGrafico().remove(this.grafico.getGrafico());
		map.getMapaGrafico().repaint();
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3950);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		kill();
	}
}