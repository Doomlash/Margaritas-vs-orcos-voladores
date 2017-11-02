package grafica.almacen;

import logica.juego.*;
import logica.almacen.*;
import logica.almacen.creadorComprables.creadorAliados.*;
import logica.almacen.creadorComprables.creadorPremios.CreadorBomba;
import logica.almacen.creadorComprables.creadorPremios.CreadorBooster;
import logica.almacen.creadorComprables.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Almacen_Mercado_Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Almacen_Mercado almacen;
	private JButton colocables[];
	private Map<String,Integer> itemsPremio;
	private String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta","Barricada","Bomba","Booster","Trampa","Escudo","Cancelar"};
	private JLabel[] cantidadItems;
	
	public Almacen_Mercado_Panel(Almacen_Mercado a){
		Juego j = a.getJuego();
		almacen = a;
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(j.getGui().getAncho()/12,j.getGui().getAlto()));
		
		crearMapeo();
		crearBotones(j);
	}
	
	private void crearMapeo(){
		itemsPremio = new HashMap<String,Integer>();
		for(int i=6;i<10;i++){
			itemsPremio.put(c[i], 0);
		}
	}
	
	private void crearBotones(Juego j){
		//"Barricada","Dragon","Armadura","Curacion","Booster","Escudo","Bomba","Trampa"};
		colocables = new JButton[c.length];
		cantidadItems = new JLabel[4];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			if(i>=6&&i<10){
				colocables[i].setBounds(0,i*j.getGui().getAlto()/20,j.getGui().getAncho()/15,j.getGui().getAlto()/20);
				cantidadItems[i-6] = new JLabel("x0");
				cantidadItems[i-6].setBounds(j.getGui().getAncho()/15,i*j.getGui().getAlto()/20,j.getGui().getAncho()/12,j.getGui().getAlto()/20);
				this.add(cantidadItems[i-6]);
			}
			else
				colocables[i].setBounds(0,i*j.getGui().getAlto()/20,j.getGui().getAncho()/12,j.getGui().getAlto()/20);
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
				case("Barricada"):{
					almacen.asignarCreador(new CreadorBarricada());
					break;
				}
				case("Bomba"):{
					almacen.asignarCreador(new CreadorBomba());
					break;
				}
				case("Booster"):{
					almacen.asignarCreador(new CreadorBooster());
					break;
				}
				case("Trampa"):{
					break;
				}
				case("Escudo"):{
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