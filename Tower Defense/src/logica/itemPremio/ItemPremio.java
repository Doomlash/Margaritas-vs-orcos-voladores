package logica.itemPremio;

import logica.gameObjects.*;
import logica.mapa.*;

public abstract class ItemPremio extends GameObject{
	
	public ItemPremio(int x, int y, int dx, Mapa m){
		super(x,y,dx,m);
	}
	
	protected int tiempo;
}