package logica.itemPremio;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.itemPremio.*;
import grafica.gameObjects.*;

public abstract class ItemPremio extends GameObject implements Runnable{
	protected GraphicItemPremio grafico;
	
	public ItemPremio(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	
	public void run(){
		try{
			Thread.sleep(7000);
		}catch(InterruptedException e){
		}
		kill();
	}
	
	public void kill(){
		
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}