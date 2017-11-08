package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemEscudo extends ItemPremio{

	public ItemEscudo(int x, int y, Mapa m){
		super(x,y,m);
		grafico = new GraphicItemEscudo(x,y,this);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void clickeado(){
		map.getNivel().getJuego().getAlmacen().getAlmacenPanel().aumentarCantidad("Escudo");
		kill();
	}
}