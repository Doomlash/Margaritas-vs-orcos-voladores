package grafica.gameObjects;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GraphicGameObject{
	protected JLabel grafico;
	protected Icon[] imagenes;
	protected final int widthOne=90;
	protected final int width;
	protected final int height = 95;
	protected final String dir = "src/Sprites/";
	protected int prioridad;
	
	protected Point pos;
	
	/**
	 * Se inicializa la posicion grafica a traves de la posicion lógica recibida.
	 * Se crea un arreglo de iconos. 
	 * @param x : int - Columna inicial de la matriz del mapa.
	 * @param y : int - Fila de la matriz del mapa
	 */
	public GraphicGameObject(int x, int y, int p, int ancho){
		width=widthOne*ancho;
		this.pos = new Point(x*widthOne,y*height+40);
		imagenes = new Icon[1];
		prioridad=p;
	}
	
	/**
	 * Se setea la nueva posicion gráfica.
	 * @param newX : int
	 * @param newY : int
	 */
	public void cambiarPos(int newX, int newY){
		pos.setLocation(newX, newY);
		getGrafico().setBounds(pos.x, pos.y, width, height);
	}
	public void setImageIdle(){
		this.grafico.setIcon(imagenes[0]);
	}
	
	public int getPrioridad(){
		return prioridad;
	}
	public Point getPos(){
		return pos;
	}
	public int getWidthUnaCelda(){
		return widthOne;
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
			this.grafico.setHorizontalAlignment(JLabel.CENTER);
			this.grafico.setVerticalAlignment(JLabel.CENTER);
		}
		return this.grafico;
	}
}