package grafica.itemPremio;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicItemTrampa extends GraphicGameObject{
	
	public GraphicItemTrampa(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ItemTrampa"+ext);
	}
}