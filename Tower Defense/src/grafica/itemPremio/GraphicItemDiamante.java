package grafica.itemPremio;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicItemDiamante extends GraphicGameObject{

	
	public GraphicItemDiamante(int x, int y){
		super(x,y,2);

		imagenes[0] = new ImageIcon(dir+"ItemDiamante.png");
	}
}