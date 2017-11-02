package grafica.itemPremio;

import javax.swing.ImageIcon;

public class GraphicItemTrampa extends GraphicItemPremio{
	
	public GraphicItemTrampa(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ItemTrampa.png");
	}
}