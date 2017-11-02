package grafica.itemPremio;

import logica.itemPremio.*;

import javax.swing.ImageIcon;

public class GraphicItemBomba extends GraphicItemPremio{
	
	public GraphicItemBomba(int x, int y, ItemPremio i){
		super(x,y);
		this.item = i;

		imagenes[0] = new ImageIcon(dir+"BombaItemChico.png");
		imagenes[1] = new ImageIcon(dir+"BombaItemGrande.png");
		
		this.getGrafico().addMouseListener(new Oyente());
	}
}