package logica.disparo.disparoEnemigo;

import logica.disparo.*;
import logica.mapa.*;
import logica.visitor.visitorEnemigo.*;
import grafica.gameObjects.*;

public abstract class DisparoEnemigo extends Disparo{
	protected VisitorDisparoEnemigo visitorDisparoEnemigo;

	public DisparoEnemigo(int x,int y, Mapa m, int a){
		super(x-1,y,m,a);
		visitorDisparoEnemigo = new VisitorDisparoEnemigo(this);
	}
	public void ejecutar(){
		if((x<0)||(x==alcance-1))
			kill();
		else{
			map.getCelda(x, y).accept(visitorDisparoEnemigo);
			if(canMove){
				int aux= x*grafico.getWidthUnaCelda();
				grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y+4);
				if(grafico.getPos().x<aux)
					x--;
			}
		}
	}
	public void kill(){
		visitorDisparoEnemigo.kill();
		map.getAlmacenHilos().getDisEnemigo().disparoEnemigoAEliminar(this);
		map.getMapaGrafico().removeGraphicElemento(grafico);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}