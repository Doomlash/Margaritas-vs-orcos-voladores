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
	private ImageIcon[] fondos;
	private JPanel[] paneles;
	
	public PanelInformacion(VentanaInicio v){
		ventana=v;
		setLayout(null);
		setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		
		fondo = new JLabel(new ImageIcon("src/Sprites/IconosBotones/FondoInicio.png"));
		fondo.setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		crearPaneles();
		armarBotones();
		fondos();
		add(fondo);
	}
	private void crearPaneles(){
		paneles = new JPanel[4];
		paneles[0] = new PanelInformacionIndividual(ventana,"Aliados");
		paneles[1] = new PanelInformacionIndividual(ventana,"Enemigos");
		paneles[2] = new PanelInformacionIndividual(ventana,"Premios");
		paneles[3] = new PanelInformacionIndividual(ventana,"ComoJugar");
	}
	private void armarBotones(){
		String[] command = {"Aliados","Enemigos","Premios","ComoJugar","Salir"};
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
			if(i==botones.length-1){
				botones[i].setIcon(new ImageIcon("src/Sprites/IconosBotones/BotonInicio"+command[i]+".png"));
				botones[i].setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/BotonInicio"+command[i]+"Entered.png"));
			}
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
		back.setPressedIcon(new ImageIcon("src/Sprites/IconosBotones/BackSelected.png"));
		add(back);
	}
	private void fondos(){
		String[] command = {"Aliados","Enemigos","Salir"};
		fondos = new ImageIcon[command.length];
		for(int i=0;i<fondos.length;i++){
			fondos[i] = new ImageIcon("src/Sprites/IconosBotones/Informacion"+command[i]+".png");
		}
	}
	private void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	private class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			switch(s){
				case("Aliados"):{
//					for(int i=0;i<botones.length;i++){
//						botones[i].setVisible(false);
//						botones[i].setEnabled(false);
//					}
//					fondo.setIcon(fondos[0]);
//					repaint();
					cambiar(paneles[0]);
					break;
				}
				case("Enemigos"):{
					cambiar(paneles[1]);
					break;
				}
				case("Premios"):{
					cambiar(paneles[2]);
					break;
					
				}
				case("ComoJugar"):{
					cambiar(paneles[3]);
					break;
					
				}
				case("Back"):{
					cambiar(ventana.getInicio());
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