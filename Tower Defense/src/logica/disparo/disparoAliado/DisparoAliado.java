package logica.disparo.disparoAliado;

import logica.disparo.*;
import logica.mapa.*;
import logica.visitor.*;
import grafica.gameObjects.GraphicGameObject;

public abstract class DisparoAliado extends Disparo{
	protected VisitorDisparoAliado visitorDisparoAliado;

	public DisparoAliado(int x,int y, Mapa m, int a){
		super(x,y,m,a);
		visitorDisparoAliado = new VisitorDisparoAliado(this);
	}
	public void ejecutar(){
		if((x>=map.getCeldas()[0].length-1)||(x==alcance+1))
			kill();
		else{
			map.getCelda(x, y).accept(visitorDisparoAliado);
			if(canMove){
				int aux= x*grafico.getWidthUnaCelda();
				grafico.cambiarPos(grafico.getPos().x+velocidad, grafico.getPos().y);
				if(grafico.getPos().x>aux)
					x++;
				}
			}
	}
	public void kill(){
		visitorDisparoAliado.kill();
		map.getAlmacenHilos().getDisAliado().disparoAliadoAEliminar(this);
		map.getMapaGrafico().removeGraphicElemento(grafico);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}