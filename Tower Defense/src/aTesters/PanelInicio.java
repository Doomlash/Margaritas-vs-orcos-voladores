package aTesters;

import aTesters.PanelInformacion.*;
import grafica.gui.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicio extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton[] botones;
	private JLabel fondo;
	private VentanaInicio ventana;
	
	public PanelInicio(VentanaInicio v){
		ventana=v;
		setLayout(null);
		setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		
		fondo = new JLabel(new ImageIcon("src/Sprites/IconosBotones/FondoInicio.png"));
		fondo.setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		armarBotones();
		add(fondo);
	}
	private void armarBotones(){
		String[] command = {"Jugar","Continuar","Informacion","Salir"};
		botones = new JButton[command.length];
		OyenteBotones oyente = new OyenteBotones();
		
		for(int i=0;i<botones.length;i++){
			botones[i] = new JButton();
			botones[i].setBorder(null);
			botones[i].setBorderPainted(false);
			botones[i].setContentAreaFilled(false);
			botones[i].setActionCommand(command[i]);
			botones[i].setBounds(200,(i+1)*70+45,300,70);
			botones[i].setFocusable(false);
			botones[i].addActionListener(oyente);
			botones[i].setIcon(new ImageIcon("src/Sprites/IconosBotones/BotonInicio"+command[i]+".png"));
			botones[i].setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/BotonInicio"+command[i]+"Entered.png"));
			add(botones[i]);
		}
		botones[1].setEnabled(false);
	}
	private void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	
	private class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			switch(s){
				case("Jugar"):{
					GUI g = ventana.getGUIJuego();
					if(g!=null){
						g.terminate();
					}
					g = new GUI(ventana);
					botones[1].setEnabled(true);
					g.ejecutar();
					ventana.cambiarJuego(g);
					cambiar(g);
					break;
				}
				case("Continuar"):{
					ventana.getGUIJuego().ejecutar();
					cambiar(ventana.getGUIJuego());
					break;
				}
				case("Informacion"):{
					cambiar(ventana.getInformacion());
					break;
				}
				case("Salir"):{
					ventana.dispose();
					break;
				}
			}
		}
	}
}