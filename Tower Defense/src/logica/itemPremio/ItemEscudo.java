package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemEscudo extends ItemPremio{

	public ItemEscudo(int x, int y, Mapa m){
		super(x,y,1,m);
		grafico = new GraphicItemEscudo(x,y);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void clickeado(){
		kill();
	}
}