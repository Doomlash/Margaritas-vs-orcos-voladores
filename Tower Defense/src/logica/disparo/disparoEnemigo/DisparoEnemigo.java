package logica.disparo.disparoEnemigo;

import logica.disparo.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.disparo.disparoEnemigo.*;
import grafica.gameObjects.*;

public abstract class DisparoEnemigo extends Disparo{
	protected GraphicDisparoEnemigo grafico;
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
				int aux= this.getGraphic().getPos().x-this.getGraphic().getWidthUnaCelda();
				while(this.getGraphic().getPos().x-velocidad>aux){
					this.getGraphic().cambiarPos(this.getGraphic().getPos().x-velocidad, this.getGraphic().getPos().y+4);
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
					}
				}
				if(canMove){
					x--;
				}
				
			}
		}
		
		if((x-1>=0)&&(x>=alcance)){
			map.getCelda(x-1, y).accept(visitorDisparoEnemigo);
			if(canMove){
				int aux= x*grafico.getWidthUnaCelda()-(grafico.getWidthUnaCelda()+17);
				grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y);
				
				if(grafico.getPos().x<aux){
					if(x>=0){
						x--;
					}
				}
			}
		}
		else
			kill();
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