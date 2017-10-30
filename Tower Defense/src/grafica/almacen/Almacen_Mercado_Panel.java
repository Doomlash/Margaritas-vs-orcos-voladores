package grafica.almacen;

import logica.juego.*;
import logica.almacen.*;
import logica.almacen.creadorComprables.creadorAliados.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Almacen_Mercado_Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Almacen_Mercado almacen;
	
	public Almacen_Mercado_Panel(Almacen_Mercado a){
		Juego j = a.getJuego();
		almacen = a;
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(j.getGui().getAncho()/12,j.getGui().getAlto()));
				
		crearBotones(j);
	}
	
	private void crearBotones(Juego j){
		String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta","Cancelar"};
		//"Barricada","Dragon","Armadura","Curacion","Booster","Escudo","Bomba","Trampa"};
		JButton colocables[] = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			colocables[i].setBounds(0,i*j.getGui().getAlto()/15,j.getGui().getAncho()/12,j.getGui().getAlto()/15);
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			this.add(colocables[i]);
		}
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			switch(s){
				case("Caballero"):{
					System.out.println("Creador caballero");
					almacen.asignarCreador(new CreadorCaballero());
					break;
				}
				case("Arquero"):{
					almacen.asignarCreador(new CreadorArquero());
					break;
				}
				case("Monje"):{
					almacen.asignarCreador(new CreadorMonje());
					break;
				}
				case("Catapulta"):{
					almacen.asignarCreador(new CreadorCatapulta());
					break;
				}
				case("Mago"):{
					almacen.asignarCreador(new CreadorMago());
					break;
				}
				case("Cancelar"):{
					almacen.asignarCreador(null);
					break;
				}
			}
		}
	}
}