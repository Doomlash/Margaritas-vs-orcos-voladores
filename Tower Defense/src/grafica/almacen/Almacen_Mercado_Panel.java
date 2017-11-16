package grafica.almacen;

import logica.juego.*;
import logica.almacen.*;
import logica.almacen.creadorComprables.creadorAliados.*;
import logica.almacen.creadorComprables.*;
import logica.almacen.creadorComprables.creadorPremios.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Almacen_Mercado_Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Almacen_Mercado almacen;
	private JButton colocables[];
	private Map<String,Integer> itemsPremio;
	private String c[] = {"Swordman","Arquero","Angel","Mago","Ballesta","Barricada","Stun","Curacion","Upgrade","Gusano","Bomba","Booster","Escudo","Trampa","Venta","Cancelar"};
	private JLabel[] cantidades;
	private JLabel presupuesto,iconMonedas,etiquetaShop,etiquetaPremios,fondo;
	protected final String dir = "src/Sprites/";
	
	public Almacen_Mercado_Panel(Almacen_Mercado a){
		Juego j = a.getJuego();
		almacen = a;
		this.setLayout(null);
		int ancho = j.getGui().getAncho();
		int alto = j.getGui().getAlto();
		this.setBounds(0,alto/12,ancho/17*3,alto-100);
		
		
		crearMapeo();
		crearEtiquetas(ancho,alto);
		crearBotones(ancho,alto);
		otrasEtiquetas(ancho,alto);
	}
	
	private void crearMapeo(){
		itemsPremio = new HashMap<String,Integer>();
		for(int i=10;i<14;i++){
			itemsPremio.put(c[i], 10);
		}
	}
	public void actualizarPresupuesto(){
		presupuesto.setText(""+almacen.getJuego().getNivel().getPresupuesto());
	}
	public void disminuirCantidad(String s){
		itemsPremio.put(s, itemsPremio.get(s)-1);
		actualizarEtiquetas();
	}
	public void aumentarCantidad(String s){
		itemsPremio.put(s, itemsPremio.get(s)+1);
		actualizarEtiquetas();
	}
	public void desactivar(){
		for(int i=0;i<colocables.length;i++){
			colocables[i].setEnabled(false);
		}
		for(int i=0;i<cantidades.length;i++)
			cantidades[i].setVisible(false);
		fondo.setIcon(new ImageIcon(dir+"IconosBotones/FondoMercadoOscuro.png"));
		etiquetaShop.setIcon(new ImageIcon(dir+"IconosBotones/ShopEtiquetaOscura.png"));
		etiquetaPremios.setIcon(new ImageIcon(dir+"IconosBotones/PremiosEtiquetaOscura.png"));
	}
	public void activar(){
		for(int i=0;i<colocables.length;i++){
			colocables[i].setEnabled(true);
		}
		for(int i=0;i<cantidades.length;i++)
			cantidades[i].setVisible(true);
		fondo.setIcon(new ImageIcon(dir+"IconosBotones/FondoMercado.png"));
		etiquetaShop.setIcon(new ImageIcon(dir+"IconosBotones/ShopEtiqueta.png"));
		etiquetaPremios.setIcon(new ImageIcon(dir+"IconosBotones/PremiosEtiqueta.png"));
	}
	private void actualizarEtiquetas(){
		for(int i=10;i<14;i++){
			cantidades[i-10].setText(c[i]+" x"+itemsPremio.get(c[i]));
			cantidades[i-10].setName(c[i]+" x"+itemsPremio.get(c[i]));
			if(itemsPremio.get(c[i])==0)
				colocables[i].setEnabled(false);
			else
				colocables[i].setEnabled(true);
		}
	}
	
	private void crearBotones(int ancho, int alto){
		colocables = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		int[] fila = {0,0,0,1,1,2,2,2,3,3,5,5,6,6,7,7};
		int x=0;
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton();
			colocables[i].setActionCommand(c[i]);
			colocables[i].setBorder(null);
			colocables[i].setBorderPainted(false);
			colocables[i].setContentAreaFilled(false);
			colocables[i].setIcon(new ImageIcon(dir+"IconosBotones/Sel"+c[i]+".png"));
			colocables[i].setPressedIcon(new ImageIcon(dir+"IconosBotones/Des"+c[i]+".png"));
			colocables[i].setRolloverIcon(new ImageIcon(dir+"IconosBotones/Entered"+c[i]+".png"));
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			this.add(colocables[i]);
		}
		int i=0;
		while(i<5){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45,65,65);
			i++;
			x++;
		}
		x=0;
		while(i<10){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45,65,65);
			i++;
			x++;
		}
		x=0;
		while(i<14){
			x=x%2;
			colocables[i].setBounds(x*65+(x+1)*14,fila[i]*alto/12+(fila[i])*9+30+((fila[i])/6*4),65,65);
			i++;
			x++;
		}
		x=0;
		while(i<16){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+65,65,65);
			i++;
			x++;
		}
	}
	private void crearEtiquetas(int ancho, int alto){
		cantidades = new JLabel[4];
		int[] fila = {5,5,6,6};
		int x=0;
		for(int i=0;i<cantidades.length;i++){
			cantidades[i] = new JLabel();
			cantidades[i].setBorder(null);
			cantidades[i].setForeground(Color.BLACK);
			x=x%2;
			cantidades[i].setBounds(x*65+2+(x+1)*14,fila[i]*alto/12+(fila[i])*7+25+(i/2)*6,70,20);
			cantidades[i].setFocusable(false);
			cantidades[i].setText(c[i+10]+" x"+itemsPremio.get(c[i+10]));
			cantidades[i].setFont(new Font("Arial",Font.ITALIC,13));
			this.add(cantidades[i]);
			x++;
		}
	}
	private void otrasEtiquetas(int ancho, int alto){
		iconMonedas = new JLabel(new ImageIcon(dir+"IconosBotones/IconMonedas.png"));
		iconMonedas.setBounds(110,7,30,30);
		iconMonedas.setHorizontalAlignment(JLabel.CENTER);
		iconMonedas.setVerticalAlignment(JLabel.CENTER);
		
		presupuesto = new JLabel();
		presupuesto.setBounds(100,0,160,45);
		presupuesto.setText(""+almacen.getJuego().getNivel().getPresupuesto());
		presupuesto.setHorizontalAlignment(JLabel.CENTER);
		presupuesto.setVerticalAlignment(JLabel.CENTER);
		presupuesto.setForeground(Color.WHITE);
		presupuesto.setFont(new Font("Arial",Font.ITALIC,20));
		
		etiquetaShop = new JLabel(new ImageIcon(dir+"IconosBotones/ShopEtiqueta.png"));
		etiquetaShop.setBounds(0,4,90,47);
		etiquetaPremios = new JLabel(new ImageIcon(dir+"IconosBotones/PremiosEtiqueta.png"));
		etiquetaPremios.setBounds(0,alto/12*5+20,210,47);
		fondo = new JLabel(new ImageIcon(dir+"IconosBotones/FondoMercado.png"));
		fondo.setBounds(0, 0, ancho/17*3, alto-100);
		add(etiquetaShop);
		add(iconMonedas);
		add(presupuesto);
		add(etiquetaPremios);
		add(fondo);
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			switch(s){
				case("Swordman"):{
					almacen.asignarAccion(new CreadorSwordman());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();					
					break;
				}
				case("Arquero"):{
					almacen.asignarAccion(new CreadorArquero());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Angel"):{
					almacen.asignarAccion(new CreadorAngel());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Ballesta"):{
					almacen.asignarAccion(new CreadorBallesta());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Mago"):{
					almacen.asignarAccion(new CreadorMago());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Barricada"):{
					almacen.asignarAccion(new CreadorBarricada());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Stun"):{
					almacen.asignarAccion(new CreadorStun());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().quitarGrilla();
					break;
				}
				case("Gusano"):{
					almacen.asignarAccion(new CreadorAgujeroGusano());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Curacion"):{
					almacen.asignarAccion(new CreadorCuracion());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Venta"):{
					almacen.asignarAccion(new Venta());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().quitarGrilla();
					break;
				}
				case("Bomba"):{
					almacen.asignarAccion(new CreadorBomba());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Booster"):{
					almacen.asignarAccion(new CreadorBooster());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().quitarGrilla();
					break;
				}
				case("Escudo"):{
					almacen.asignarAccion(new CreadorEscudo());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().quitarGrilla();
					break;
				}
				case("Trampa"):{
					almacen.asignarAccion(new CreadorTrampa());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().añadirGrilla();
					break;
				}
				case("Upgrade"):{
					almacen.asignarAccion(new CreadorUpgrade());
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().quitarGrilla();
					break;
				}
				case("Cancelar"):{
					almacen.asignarAccion(null);
					almacen.getJuego().getNivel().getMapa().getMapaGrafico().quitarGrilla();
					break;
				}
			}
		}
	}
}