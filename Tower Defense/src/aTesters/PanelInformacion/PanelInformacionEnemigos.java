package aTesters.PanelInformacion;

import aTesters.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacionEnemigos extends JPanel{
	private static final long serialVersionUID = 1L;
	private VentanaInicio ventana;
	private ImageIcon[] fondos;
	private int actualImage=0;
	private JLabel fondo;
	private JButton[] botones;
	
	public PanelInformacionEnemigos(VentanaInicio v){
		ventana=v;
		setLayout(null);
		setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		
		fondos = new ImageIcon[2];
		for(int i=0;i<fondos.length;i++){
			fondos[i] = new ImageIcon("src/Sprites/IconosBotones/InformacionEnemigos"+(i+1)+".png");
		}
		fondo = new JLabel(fondos[actualImage]);
		fondo.setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		armarBotones();
		add(fondo);
	}
	
	private void armarBotones(){
		String[] command = {"Back","Prev","Next"};
		botones = new JButton[command.length];
		OyenteBotones oyente = new OyenteBotones();
		for(int i=0;i<command.length;i++){
			botones[i]=new JButton();
			botones[i].setActionCommand(command[i]);
			botones[i].setBorder(null);
			botones[i].setBorderPainted(false);
			botones[i].setContentAreaFilled(false);
			botones[i].setFocusable(false);
			botones[i].addActionListener(oyente);	
			botones[i].setIcon(new ImageIcon("src/Sprites/IconosBotones/"+command[i]+".png"));
			botones[i].setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/"+command[i]+"Entered.png"));
			add(botones[i]);
		}
		
		botones[0].setBounds(195,50,60,60);
		
		botones[1].setBounds(190,525,60,60);
		
		botones[2].setBounds(925,525,60,60);
		
		botones[1].setVisible(false);
		botones[1].setEnabled(false);
	}
	private void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	private class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			switch(s){
				case("Back"):{
					cambiar(new PanelInformacion(ventana));
					break;
				}
				case("Prev"):{
					actualImage--;
					fondo.setIcon(fondos[actualImage]);
					if(actualImage==0){
						botones[1].setVisible(false);
						botones[1].setEnabled(false);
					}
					botones[2].setVisible(true);
					botones[2].setEnabled(true);
					break;
				}
				case("Next"):{
					actualImage++;
					fondo.setIcon(fondos[actualImage]);
					if(actualImage==fondos.length-1){
						botones[2].setVisible(false);
						botones[2].setEnabled(false);
					}
					botones[1].setVisible(true);
					botones[1].setEnabled(true);
					break;
				}
			}
		}
	}
}