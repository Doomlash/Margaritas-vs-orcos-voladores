package logica.itemPremio;

import logica.mapa.Mapa;
import grafica.itemPremio.*;

public class ItemDiamante extends ItemPremio{

	public ItemDiamante(int x, int y, Mapa m){
		super(x,y,m);
		grafico = new GraphicItemDiamante(x,y,this);
		m.getMapaGrafico().addGraphicElemento(grafico);
	}
	public void clickeado(){
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()+500);
		kill();
	}
}