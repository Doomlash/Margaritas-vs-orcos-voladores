package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemTrampa extends ItemPremio{

	public ItemTrampa(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicItemTrampa(x,y,this);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void clickeado(){
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().aumentarCantidad("Trampa");
		kill();
	}
}