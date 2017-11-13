package aTesters.PanelInformacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aTesters.PanelInicio;
import aTesters.VentanaInicio;

public class PanelInformacion extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton[] botones;
	private JLabel fondo;
	private VentanaInicio ventana;
	private JButton back;
	
	public PanelInformacion(VentanaInicio v){
		ventana=v;
		setLayout(null);
		setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		
		fondo = new JLabel(new ImageIcon("src/Sprites/IconosBotones/FondoInicio.png"));
		fondo.setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		armarBotones();
		add(fondo);
	}
	private void armarBotones(){
		String[] command = {"Aliados","Enemigos","Salir"};
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
			botones[i].setIcon(new ImageIcon("src/Sprites/IconosBotones/BotonInformacion"+command[i]+".png"));
			botones[i].setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/BotonInformacionEntered"+command[i]+".png"));
			add(botones[i]);
		}
		
		back = new JButton();
		back.setActionCommand("Back");
		back.setBorder(null);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusable(false);
		back.addActionListener(oyente);
		back.setBounds(195,50,60,60);
		back.setIcon(new ImageIcon("src/Sprites/IconosBotones/Back.png"));
		back.setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/BackEntered.png"));
		add(back);
	}
	private void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	private class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			switch(s){
				case("Aliados"):{
					for(int i=0;i<botones.length;i++){
						botones[i].setVisible(false);
						botones[i].setEnabled(false);
					}
					fondo.setIcon(new ImageIcon("src/Sprites/IconosBotones/InformacionAliados.png"));
					repaint();
					break;
				}
				case("Enemigos"):{
					break;
				}
				case("Back"):{
					cambiar(new PanelInicio(ventana));
					break;
				}
			}
		}
	}
}