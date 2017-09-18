package grafica.gameObjects;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GraphicGameObject{
	protected JLabel grafico;
	protected Icon[] imagenes;
	protected final int width = 46;
	protected final int height = 46;
	protected final String dir = "src/Sprites/",ext=".png";
	
	protected Point pos;
	
	public GraphicGameObject(int x, int y){
		this.pos = new Point(x*width+(x*5),y*height+80+(y*5));
		imagenes = new ImageIcon[1];
	}
	
	public void cambiarBorde(int newX, int newY){
		grafico.setBounds(newX, newY, width, height);
		System.out.println("( "+newX+"/"+newY+" )");
	}
	public void cambiarPos(int newX, int newY){
		pos.setLocation(newX, newY);
		cambiarGrafico();
	}
	private void cambiarGrafico(){
		grafico.setBounds(pos.x, pos.y, width, height);
	}
	
	public Point getPos(){
		return pos;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public JLabel getGrafico(){
		if(this.grafico==null){
			this.grafico = new JLabel(imagenes[0]);
			this.grafico.setBounds(this.pos.x,this.pos.y,width,height);
		}
		return this.grafico;
	}
}