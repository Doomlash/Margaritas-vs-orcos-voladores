package grafica.itemPremio;

import logica.itemPremio.*;

import javax.swing.ImageIcon;

public class GraphicItemPowerBooster extends GraphicItemPremio{
	
	public GraphicItemPowerBooster(int x, int y, ItemPremio i){
		super(x,y);
		this.item = i;

		imagenes[0] = new ImageIcon(dir+"ItemsPremios/BoosterItemChico.png");
		imagenes[1] = new ImageIcon(dir+"ItemsPremios/BoosterItemGrande.png");
		
		this.getGrafico().addMouseListener(new Oyente());
	}
}