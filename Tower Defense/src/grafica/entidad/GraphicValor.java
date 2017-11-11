package grafica.entidad;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import grafica.gameObjects.*;

public class GraphicValor extends GraphicGameObject{
	
	public GraphicValor(int x, int y, int dx, int dy){
		super(x,y,1,dx,dy);
		
		this.getGrafico().setIcon(null);
		grafico.setForeground(Color.WHITE);
		grafico.setHorizontalAlignment(JLabel.LEFT);
		grafico.setVerticalAlignment(JLabel.TOP);
		grafico.setForeground(Color.WHITE);
		grafico.setFont(new Font("Arial",Font.ITALIC,12));
	}
	public void actualizar(int v){
		grafico.setText(""+v);
	}
}