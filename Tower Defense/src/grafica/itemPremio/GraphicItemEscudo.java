package grafica.itemPremio;

import javax.swing.ImageIcon;

public class GraphicItemEscudo extends GraphicItemPremio{
	
	public GraphicItemEscudo(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"ShieldIcon.png");
		imagenes[1] = new ImageIcon(dir+"ShieldIconGrande.png");
		
		this.getGrafico().addMouseListener(new Oyente());
	}
}