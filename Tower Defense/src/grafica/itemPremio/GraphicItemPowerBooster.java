package grafica.itemPremio;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicItemPowerBooster extends GraphicGameObject{
	
	public GraphicItemPowerBooster(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ItemPowerBooster"+ext);
	}
}