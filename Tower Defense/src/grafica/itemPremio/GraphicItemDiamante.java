package grafica.itemPremio;

import javax.swing.ImageIcon;

public class GraphicItemDiamante extends GraphicItemPremio{

	
	public GraphicItemDiamante(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ItemDiamante.png");
	}
}