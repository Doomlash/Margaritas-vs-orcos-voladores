package grafica.itemPremio;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicItemCampoDeProteccion extends GraphicGameObject{
	
	public GraphicItemCampoDeProteccion(int x, int y){
		super(x,y,1,1);

		imagenes[0] = new ImageIcon(dir+"ItemCampoDeProteccion.png");
	}
}