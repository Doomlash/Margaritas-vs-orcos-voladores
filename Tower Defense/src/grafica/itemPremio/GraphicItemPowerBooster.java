package grafica.itemPremio;

import javax.swing.ImageIcon;

public class GraphicItemPowerBooster extends GraphicItemPremio{
	
	public GraphicItemPowerBooster(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ItemPowerBooster.png");
	}
}