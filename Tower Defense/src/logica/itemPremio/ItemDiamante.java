package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemDiamante extends ItemPremio{

	public ItemDiamante(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicItemDiamante(x,y);
	}
}