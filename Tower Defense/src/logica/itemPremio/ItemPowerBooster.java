package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemPowerBooster extends ItemPremio{

	public ItemPowerBooster(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicItemPowerBooster(x,y);
	}
}