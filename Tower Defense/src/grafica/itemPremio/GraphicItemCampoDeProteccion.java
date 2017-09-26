package grafica.itemPremio;

import javax.swing.ImageIcon;

public class GraphicItemCampoDeProteccion extends GraphicItemPremio{
	
	public GraphicItemCampoDeProteccion(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ItemCampoDeProteccion.png");
	}
}