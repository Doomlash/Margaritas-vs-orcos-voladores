package grafica.premio;

import grafica.gameObjects.*;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class GraphicBomba extends GraphicGameObject{
	private Toolkit t = Toolkit.getDefaultToolkit();
	
	public GraphicBomba(int x, int y){
		super(x,y,1,1);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Bomba.gif"));
	}
}