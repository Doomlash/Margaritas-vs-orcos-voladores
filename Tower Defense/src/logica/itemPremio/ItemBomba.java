package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemBomba extends ItemPremio{

	public ItemBomba(int x, int y, Mapa m){
		super(x,y,m);
		grafico = new GraphicItemBomba(x,y,this);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void clickeado(){
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().aumentarCantidad("Bomba");
		kill();
	}
}