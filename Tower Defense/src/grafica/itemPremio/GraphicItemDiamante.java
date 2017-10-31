package grafica.itemPremio;

import logica.itemPremio.*;

import javax.swing.ImageIcon;

public class GraphicItemDiamante extends GraphicItemPremio{
	
	public GraphicItemDiamante(int x, int y, ItemPremio i){
		super(x,y);
		this.item = i;
		
		imagenes[0] = new ImageIcon(dir+"BolsaOroItemChico.png");
		imagenes[1] = new ImageIcon(dir+"BolsaOroItemGrande.png");
		
		this.getGrafico().addMouseListener(new Oyente());
	}
}