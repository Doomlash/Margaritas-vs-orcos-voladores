package logica.disparo.disparoEnemigo;

import logica.disparo.*;
import logica.mapa.*;
import logica.visitor.visitorEnemigo.*;
import grafica.gameObjects.*;

public abstract class DisparoEnemigo extends Disparo{
	protected VisitorDisparoEnemigo visitorDisparoEnemigo;

	public DisparoEnemigo(int x,int y, Mapa m, int a, int dam, int generacion, int cantImp){
		super(x-1,y,m,a,dam,generacion,cantImp);
		visitorDisparoEnemigo = new VisitorDisparoEnemigo(this);
	}
	public void ejecutar(){
		if(cantImpactos==0)
			kill();
		else{
			if((x<0)||(x==alcance-1))
				kill();
			else{
				Celda c = map.getCelda(x, y);
				if(c!=null)
					c.accept(visitorDisparoEnemigo);
				if(canMove){
					int aux= x*grafico.getWidthUnaCelda();
					grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y);
					if(grafico.getPos().x<aux)
						x--;
				}
			}
		}
	}
	public void kill(){
		canMove=false;
		visitorDisparoEnemigo.kill();
		map.getAlmacenHilos().getDisEnemigo().disparoEnemigoAEliminar(this);
		map.getMapaGrafico().removeGraphicElemento(grafico);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}