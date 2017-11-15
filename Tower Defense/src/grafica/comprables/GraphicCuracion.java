package grafica.comprables;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicCuracion extends GraphicGameObject{
	
	public GraphicCuracion(int x, int y){
		super(x,y,0,1,1);
		
		imagenes[0] = new ImageIcon(dir+"ParticulasCuracion.gif");
	}
}