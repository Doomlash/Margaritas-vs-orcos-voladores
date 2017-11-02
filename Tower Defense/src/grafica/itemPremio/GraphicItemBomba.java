package grafica.itemPremio;

import javax.swing.ImageIcon;

public class GraphicItemBomba extends GraphicItemPremio{
	
	public GraphicItemBomba(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Granada.png");
		imagenes[1] = new ImageIcon(dir+"Diamante.png");
	}
}