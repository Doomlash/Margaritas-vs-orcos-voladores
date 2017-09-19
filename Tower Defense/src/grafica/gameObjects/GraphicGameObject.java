package grafica.gameObjects;

import java.awt.Image;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GraphicGameObject{
	protected Image grafico;
	protected Image[] imagenes;
	protected final int width = 80;
	protected final int height = 90;
	protected final String dir = "src/Sprites/";
	protected int prioridad;
	
	protected Point pos;
	
	/**
	 * Se inicializa la posicion grafica a traves de la posicion lógica recibida.
	 * Se crea un arreglo de iconos. 
	 * @param x : int - Columna inicial de la matriz del mapa.
	 * @param y : int - Fila de la matriz del mapa
	 */
	public GraphicGameObject(int x, int y, int p){
		this.pos = new Point(x*width+90,y*height);
		imagenes = new Image[1];
		prioridad=p;
	}
	
	/**
	 * Se setea la nueva posicion gráfica.
	 * @param newX : int
	 * @param newY : int
	 */
	public void cambiarPos(int newX, int newY){
		pos.setLocation(newX, newY);
//		cambiarGrafico();
	}
	
	/**
	 * Se modifica el grafico.
	 */
//	private void cambiarGrafico(){
//		grafico.setBounds(pos.x, pos.y, width, height);
//	}
	
	public int getPrioridad(){
		return prioridad;
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
	public Image getGrafico(){
		if(this.grafico==null){
			this.grafico = imagenes[0];
		}
		return this.grafico;
	}
}