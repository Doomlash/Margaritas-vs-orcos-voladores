package logica.itemPremio;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.itemPremio.*;
import grafica.gameObjects.*;

public abstract class ItemPremio extends GameObject{
	protected GraphicItemPremio grafico;
	protected int tiempo;
	
	public ItemPremio(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
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