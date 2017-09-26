package grafica.gameObjects;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GraphicGameObject{
	protected JLabel grafico;
	protected Icon[] imagenes;
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
		width=90*ancho;
		this.pos = new Point(x*90,y*height);
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
		grafico.setBounds(pos.x, pos.y, width, height);
	}
	
	/**
	 * Se modifica el grafico.
	 */
	public void cambiarGrafico(int i){
		if(i<imagenes.length)
			grafico.setIcon(imagenes[i]);
	}
	
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