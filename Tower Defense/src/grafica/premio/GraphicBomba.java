package grafica.premio;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public class GraphicBomba extends GraphicGameObject{
	
	
	public GraphicBomba(int x, int y){
		super(x,y,1,1);
		Toolkit t = Toolkit.getDefaultToolkit ();
		imagenes[0] = new ImageIcon(t.createImage(dir+"Bomba.gif"));
		
	}
}