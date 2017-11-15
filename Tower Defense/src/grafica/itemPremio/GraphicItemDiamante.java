package grafica.itemPremio;

import logica.itemPremio.*;

import javax.swing.ImageIcon;

public class GraphicItemDiamante extends GraphicItemPremio{
	
	public GraphicItemDiamante(int x, int y, ItemPremio i){
		super(x,y);
		this.item = i;
		
		imagenes[0] = new ImageIcon(dir+"DiamanteItemChico.png");
		imagenes[1] = new ImageIcon(dir+"DiamanteItemGrande.png");
		
		this.getGrafico().addMouseListener(new Oyente());
	}
}