package grafica.almacen;

import logica.juego.*;
import logica.almacen.*;
import logica.almacen.creadorComprables.creadorAliados.*;
import logica.almacen.creadorComprables.*;
import logica.almacen.creadorComprables.creadorPremios.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Almacen_Mercado_Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Almacen_Mercado almacen;
	private JButton colocables[];
	private Map<String,Integer> itemsPremio;
	private String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta","Barricada","Bomba","Booster","Trampa","Escudo","Stun","Cancelar"};
	
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
			itemsPremio.put(c[i], 5);
		}
	}
	public void disminuirCantidad(String s){
		itemsPremio.put(s, itemsPremio.get(s)-1);
		actualizarBotones();
	}
	public void aumentarCantidad(String s){
		itemsPremio.put(s, itemsPremio.get(s)+1);
		actualizarBotones();
	}
	private void actualizarBotones(){
		for(int i=6;i<10;i++){
			colocables[i].setText(c[i]+" x"+itemsPremio.get(c[i]));
			colocables[i].setName(c[i]+" x"+itemsPremio.get(c[i]));
			if(itemsPremio.get(c[i])==0)
				colocables[i].setEnabled(false);
			else
				colocables[i].setEnabled(true);
		}
	}
	
	private void crearBotones(Juego j){
		colocables = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			colocables[i].setBounds(0,i*j.getGui().getAlto()/20,j.getGui().getAncho()/12,j.getGui().getAlto()/20);
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			this.add(colocables[i]);
		}
		actualizarBotones();
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			String[] aux = {"Bomba x"+itemsPremio.get("Bomba"),"Booster x"+itemsPremio.get("Booster"),
			"Trampa x"+itemsPremio.get("Trampa"),"Escudo x"+itemsPremio.get("Escudo")};
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
				case("Stun"):{
					almacen.asignarCreador(new CreadorStun());
					break;
				}
				case("Cancelar"):{
					almacen.asignarCreador(null);
					break;
				}
			}
			if(s.compareTo(aux[1])==0){
				almacen.asignarCreador(new CreadorBooster());
			}
			if(s.compareTo(aux[3])==0){
				almacen.asignarCreador(new CreadorEscudo());
			}
		}
	}
}