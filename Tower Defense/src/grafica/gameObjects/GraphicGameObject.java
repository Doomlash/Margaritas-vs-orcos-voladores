package grafica.gameObjects;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GraphicGameObject{
	protected JLabel grafico;
	protected Icon[] imagenes;
	protected final int width = 46;
	protected final int height = 46;
	
	protected Point pos;
	
	public GraphicGameObject(int x, int y){
		this.pos = new Point(x,y);
	}
	public Point getPos(){
		return pos;
	}
	
	public JLabel getGrafico(){
		if(this.grafico==null){
			this.grafico = new JLabel(imagenes[0]);
			this.grafico.setBounds(this.pos.x*width+5,this.pos.y*height+80,width,height);
		}
		return this.grafico;
	}
}