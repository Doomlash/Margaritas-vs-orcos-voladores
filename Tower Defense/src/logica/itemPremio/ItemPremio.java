package logica.itemPremio;

import logica.gameObjects.*;
import logica.mapa.*;

public abstract class ItemPremio extends GameObject implements Runnable{
	
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
}