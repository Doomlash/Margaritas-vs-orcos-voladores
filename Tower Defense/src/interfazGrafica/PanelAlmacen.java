package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfazGrafica.PanelInformacion.*;

public class PanelAlmacen extends JPanel{
	private static final long serialVersionUID = 1L;
	private VentanaInicio ventana;
	private JLabel fondo;
	private ImageIcon[] fondos;
	private JButton back,prev,next;
	private JPanel[] paneles;
	protected final String dir = "src/Sprites/";
	private JButton[] botones;
	private int actualImage=0;

	public PanelAlmacen(VentanaInicio v){
		ventana=v;
		setLayout(null);
		setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		
		fondos = new ImageIcon[2];
		for(int i=0;i<fondos.length;i++){
			fondos[i] = new ImageIcon(dir+"IconosBotones/InformacionAlmacen"+(i+1)+".png");
		}
		fondo = new JLabel(fondos[actualImage]);
		fondo.setBounds(0,0,v.getAncho()-15,v.getAlto()-40);
		crearPaneles();
		armarBotones();
		add(fondo);
	}
	private void crearPaneles(){
		paneles = new JPanel[2];
		paneles[0] = new PanelInformacionIndividual(ventana,"Shop");
		paneles[1] = new PanelInformacionIndividual(ventana,"Premios");
	}
	private void armarBotones(){
		String[] command = {"Shop","Premios"};
		botones = new JButton[command.length];
		OyenteBotones oyente = new OyenteBotones();
		
		for(int i=0;i<botones.length;i++){
			botones[i] = new JButton();
			botones[i].setBorder(null);
			botones[i].setBorderPainted(false);
			botones[i].setContentAreaFilled(false);
			botones[i].setActionCommand(command[i]);
			botones[i].setBounds(200,(i+1)*70+145,300,70);
			botones[i].setFocusable(false);
			botones[i].addActionListener(oyente);
			botones[i].setIcon(new ImageIcon(dir+"IconosBotones/BotonInformacion"+command[i]+".png"));
			botones[i].setRolloverIcon(new ImageIcon(dir+"IconosBotones/BotonInformacionEntered"+command[i]+".png"));
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
		back.setIcon(new ImageIcon(dir+"IconosBotones/Back.png"));
		back.setRolloverIcon(new ImageIcon(dir+"IconosBotones/BackEntered.png"));

		prev = new JButton();
		prev.setActionCommand("Prev");
		prev.setBorder(null);
		prev.setBorderPainted(false);
		prev.setContentAreaFilled(false);
		prev.setFocusable(false);
		prev.addActionListener(oyente);
		prev.setBounds(190,525,60,60);
		prev.setIcon(new ImageIcon(dir+"IconosBotones/Prev.png"));
		prev.setRolloverIcon(new ImageIcon(dir+"IconosBotones/PrevEntered.png"));

		next = new JButton();
		next.setActionCommand("Next");
		next.setBorder(null);
		next.setBorderPainted(false);
		next.setContentAreaFilled(false);
		next.setFocusable(false);
		next.addActionListener(oyente);
		next.setBounds(925,525,60,60);
		next.setIcon(new ImageIcon(dir+"IconosBotones/Next.png"));
		next.setRolloverIcon(new ImageIcon(dir+"IconosBotones/NextEntered.png"));
		
		prev.setVisible(false);
		prev.setEnabled(false);
		
		add(back);
		add(prev);
		add(next);
	}
	private void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	private class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			switch(s){
				case("Shop"):{
					cambiar(paneles[0]);
					break;
				}
				case("Premios"):{
					cambiar(paneles[1]);
					break;
					
				}
				case("Back"):{
					cambiar(ventana.getInformacion());
					break;
				}
				case("Prev"):{
					actualImage--;
					fondo.setIcon(fondos[actualImage]);
					if(actualImage==0){
						prev.setVisible(false);
						prev.setEnabled(false);
						for(int i=0;i<botones.length;i++){
							botones[i].setVisible(true);
							botones[i].setEnabled(true);
						}
					}
					next.setVisible(true);
					next.setEnabled(true);
					break;
				}
				case("Next"):{
					actualImage++;
					fondo.setIcon(fondos[actualImage]);
					for(int i=0;i<botones.length;i++){
						botones[i].setVisible(false);
						botones[i].setEnabled(false);
					}
					if(actualImage==fondos.length-1){
						next.setVisible(false);
						next.setEnabled(false);
					}
					prev.setVisible(true);
					prev.setEnabled(true);
					break;
				}
			}
		}
	}
}