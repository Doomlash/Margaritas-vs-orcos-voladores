package grafica.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel puntaje, tiempo, hordas, levelProgress, levelProgressText, levelText, numberLevel;
	protected final String dir = "src/Sprites/";
	private ImageIcon[] cantHordas, progress, numLevel;
	private int hordaActual=0, actualLevel=0;
	private PanelJuego gui;
	
	public PanelSuperior(int AnchoVentana, int AltoVentana, PanelJuego g){
		gui=g;
		setLayout(null);
		setBounds(0, 0, AnchoVentana-10, AltoVentana/12);
		
		puntaje = new JLabel();
		puntaje.setBounds(AnchoVentana-150,0,150,60);
		puntaje.setText("Puntaje: "+gui.getJuego().getPuntaje());
		puntaje.setHorizontalAlignment(JLabel.LEFT);
		puntaje.setVerticalAlignment(JLabel.CENTER);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Arial",Font.ITALIC,20));
		
		tiempo = new JLabel();
		tiempo.setBounds(AnchoVentana-300,0,150,60);
		tiempo.setText("Tiempo: "+gui.getJuego().getTiempo());
		tiempo.setHorizontalAlignment(JLabel.LEFT);
		tiempo.setVerticalAlignment(JLabel.CENTER);
		tiempo.setForeground(Color.WHITE);
		tiempo.setFont(new Font("Arial",Font.ITALIC,20));
		
		hordas();
		backButton();

		JLabel fondo = new JLabel(new ImageIcon(dir+"IconosBotones/FondoSuperior.png"));
		fondo.setBounds(0, 0, AnchoVentana-15, AltoVentana/12);
		
		add(puntaje);
		add(tiempo);
		add(fondo);
	}
	private void backButton(){
		JButton back = new JButton();
		back.setBorder(null);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gui.getJuego().pausar();
				gui.pausar();
				gui.cambiar(gui.getVentana().getInicio());
			}
		});
		back.setBounds(20,0,60,60);
		back.setIcon(new ImageIcon(dir+"IconosBotones/BackMenu.png"));
		back.setRolloverIcon(new ImageIcon(dir+"IconosBotones/BackMenuEntered.png"));
		back.setPressedIcon(new ImageIcon(dir+"IconosBotones/BackMenuSelected.png"));
		add(back);
	}
	private void hordas(){
		cantHordas = new ImageIcon[3];
		for(int i=0;i<cantHordas.length;i++){
			cantHordas[i] = new ImageIcon(dir+"IconosBotones/Horda"+(i+1)+".png");
		}
		
		hordas = new JLabel(cantHordas[hordaActual]);
		hordas.setBounds(370,0,150,60);
		hordas.setHorizontalAlignment(JLabel.LEFT);
		hordas.setVerticalAlignment(JLabel.CENTER);
		
		progress = new ImageIcon[16];
		for(int i=0;i<progress.length;i++)
			progress[i] = new ImageIcon(dir+"IconosBotones/LevelProgress/LevelProgress"+(i+1)+".png");
		
		levelProgress = new JLabel(progress[0]);
		levelProgress.setBounds(370,0,150,60);
		levelProgress.setHorizontalAlignment(JLabel.LEFT);
		levelProgress.setVerticalAlignment(JLabel.CENTER);
		
		levelProgressText = new JLabel(new ImageIcon(dir+"IconosBotones/LevelProgress/LevelProgressText.png"));
		levelProgressText.setBounds(220,0,150,60);
		levelProgressText.setHorizontalAlignment(JLabel.LEFT);
		levelProgressText.setVerticalAlignment(JLabel.CENTER);
		
		levelText = new JLabel(new ImageIcon(dir+"IconosBotones/LevelText.png"));
		levelText.setBounds(500,0,150,60);
		levelText.setHorizontalAlignment(JLabel.LEFT);
		levelText.setVerticalAlignment(JLabel.CENTER);
		
		numLevel = new ImageIcon[3];
		for(int i=0;i<3;i++){
			numLevel[i] = new ImageIcon(dir+"IconosBotones/Level"+(i+1)+".png");
		}
		numberLevel = new JLabel(numLevel[actualLevel]);
		numberLevel.setBounds(540,0,150,60);
		numberLevel.setHorizontalAlignment(JLabel.LEFT);
		numberLevel.setVerticalAlignment(JLabel.CENTER);
		
		add(numberLevel);
		add(levelText);
		add(levelProgressText);
		add(levelProgress);
		add(hordas);
	}
	public void actualizarLevelProgress(int numEne, int numEneMax){
		int barraBuscada= (numEne*90)/numEneMax;
		barraBuscada = barraBuscada/6;
		levelProgress.setIcon(progress[barraBuscada]);
	}
	public void actualizarPuntaje(){
		puntaje.setText("Puntaje: "+gui.getJuego().getPuntaje());		
	}
	public void actualizarTemporizador(){
		tiempo.setText("Tiempo: "+gui.getJuego().getTiempo());
	}
	public void actualizarNumHordas(){
		hordaActual=(hordaActual+1)%cantHordas.length;
		hordas.setIcon(cantHordas[hordaActual]);
	}
	public void nextNumLevel(){
		actualLevel++;
		numberLevel.setIcon(numLevel[actualLevel]);
	}
}