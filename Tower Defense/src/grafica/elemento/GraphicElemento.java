package grafica.elemento;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GraphicElemento {
	protected JLabel grafico;
	protected Icon[] imagenes;
	protected final int width = 40;
	protected final int height = 40;
	
	protected Point pos;
	
	public GraphicElemento(int x, int y){
		this.pos = new Point(x,y);
	}
	public Point getPos(){
		return pos;
	}
	
	public JLabel getGrafico(){
		if(this.grafico==null){
			this.grafico = new JLabel(imagenes[0]);
			this.grafico.setBounds(this.pos.x,this.pos.y,width,height);
		}
		return this.grafico;
	}
}