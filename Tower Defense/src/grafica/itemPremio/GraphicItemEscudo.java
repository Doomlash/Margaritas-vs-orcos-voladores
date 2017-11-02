package grafica.itemPremio;

import logica.itemPremio.*;

import javax.swing.ImageIcon;

public class GraphicItemEscudo extends GraphicItemPremio{
	
	public GraphicItemEscudo(int x, int y, ItemPremio i){
		super(x,y);
		this.item = i;

		imagenes[0] = new ImageIcon(dir+"ItemCampoDeProteccion.png");
	}
}