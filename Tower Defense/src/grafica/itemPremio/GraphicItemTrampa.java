package grafica.itemPremio;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicItemTrampa extends GraphicGameObject{
	
	public GraphicItemTrampa(int x, int y){
		super(x,y,1,1);

		imagenes[0] = new ImageIcon(dir+"ItemTrampa.png");
	}
}