package logica.itemPremio;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.gameObjects.*;

public abstract class ItemPremio extends GameObject{
	protected int tiempo;
	
	public ItemPremio(int x, int y, Mapa m){
		super(x,y,1,1,m);
		tiempo=8;
	}
	
	public abstract void clickeado();
	
	public void reducirTiempo(){
		tiempo--;
		if(tiempo<=0)
			kill();
	}
	public void kill(){
		map.getAlmacenHilos().getItemsPremio().itemAEliminar(this);
		map.getMapaGrafico().removeGraphicElemento(grafico);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}