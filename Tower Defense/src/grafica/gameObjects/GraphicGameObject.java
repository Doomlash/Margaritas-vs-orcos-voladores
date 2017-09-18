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
	
	/**
	 * Se inicializa la posicion grafica a traves de la posicion lógica recibida.
	 * Se crea un arreglo de iconos. 
	 * @param x : int - Columna inicial de la matriz del mapa.
	 * @param y : int - Fila de la matriz del mapa
	 */
	public GraphicGameObject(int x, int y){
		this.pos = new Point(x*width+(x*5),y*height+80+(y*5));
		imagenes = new ImageIcon[1];
	}
	
	/**
	 * Se setea la nueva posicion gráfica.
	 * @param newX : int
	 * @param newY : int
	 */
	public void cambiarPos(int newX, int newY){
		pos.setLocation(newX, newY);
		cambiarGrafico();
	}
	
	/**
	 * Se modifica el grafico.
	 */
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
	
	/**
	 * 
	 * @return JLabel - Se retorna el grafico (JLabel) actual de la clase grafica.
	 * Se inicializa con el primer ícono del arreglo de íconos en caso de que el grafico sea nulo.
	 */
	public JLabel getGrafico(){
		if(this.grafico==null){
			this.grafico = new JLabel(imagenes[0]);
			this.grafico.setBounds(this.pos.x,this.pos.y,width,height);
		}
		return this.grafico;
	}
}