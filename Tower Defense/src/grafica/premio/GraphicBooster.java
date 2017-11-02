package grafica.premio;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import grafica.gameObjects.GraphicGameObject;

public class GraphicBooster extends GraphicGameObject{

	public GraphicBooster(int x, int y, int p, int ancho) {
		super(x, y, p, ancho);
		Toolkit t = Toolkit.getDefaultToolkit ();
		imagenes[0] = new ImageIcon(t.createImage(dir+"Booster.gif"));
	}

}
