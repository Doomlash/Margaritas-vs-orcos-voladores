package grafica.itemPremio;

import logica.itemPremio.*;

import javax.swing.ImageIcon;

public class GraphicItemTrampa extends GraphicItemPremio{
	
	public GraphicItemTrampa(int x, int y, ItemPremio i){
		super(x,y);
		this.item = i;


		imagenes[0] = new ImageIcon(dir+"ItemsPremios/TrampaItemChico.png");
		imagenes[1] = new ImageIcon(dir+"ItemsPremios/TrampaItemGrande.png");
		
		this.getGrafico().addMouseListener(new Oyente());
	}
}