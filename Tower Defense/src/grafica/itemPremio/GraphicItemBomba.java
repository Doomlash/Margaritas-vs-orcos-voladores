package grafica.itemPremio;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicItemBomba extends GraphicGameObject{
	
	public GraphicItemBomba(int x, int y){
		super(x,y,1,1);

		imagenes[0] = new ImageIcon(dir+"ItemBomba.png");
	}
}