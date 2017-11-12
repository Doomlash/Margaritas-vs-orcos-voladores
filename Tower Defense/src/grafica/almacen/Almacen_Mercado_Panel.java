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
import javax.swing.SwingConstants;

public class Almacen_Mercado_Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Almacen_Mercado almacen;
	private JButton colocables[];
	private Map<String,Integer> itemsPremio;
	private String c[] = {"Swordman","Arquero","Angel","Mago","Catapulta","Barricada","Stun","Curacion","Upgrade","Bomba","Booster","Trampa","Escudo","Venta","Cancelar"};
	private JLabel[] cantidades;
	
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
		for(int i=9;i<13;i++){
			itemsPremio.put(c[i], 10);
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
	public void desactivar(){
		for(int i=0;i<colocables.length;i++){
			colocables[i].setEnabled(false);
		}
		for(int i=0;i<cantidades.length;i++)
			cantidades[i].setVisible(false);
	}
	private void actualizarBotones(){
		for(int i=9;i<13;i++){
			cantidades[i-9].setText(c[i]+" x"+itemsPremio.get(c[i]));
			cantidades[i-9].setName(c[i]+" x"+itemsPremio.get(c[i]));
			if(itemsPremio.get(c[i])==0)
				colocables[i].setEnabled(false);
			else
				colocables[i].setEnabled(true);
		}
	}
	
	private void crearBotones(int ancho, int alto){
		colocables = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		int[] fila = {0,0,0,1,1,2,2,2,3,5,5,6,6,7,7};
		int x=0;
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton();
			colocables[i].setActionCommand(c[i]);
			colocables[i].setBorder(null);
			colocables[i].setBorderPainted(false);
			colocables[i].setContentAreaFilled(false);
			colocables[i].setForeground(Color.WHITE);
//			x=x%3;
//			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45+(i/13)*20,65,65);
//			colocables[i].setBounds(0,i*j.getGui().getAlto()/20,j.getGui().getAncho()/12,j.getGui().getAlto()/20);
			colocables[i].setIcon(new ImageIcon("src/Sprites/IconosBotones/Sel"+c[i]+".png"));
			colocables[i].setPressedIcon(new ImageIcon("src/Sprites/IconosBotones/Des"+c[i]+".png"));
			colocables[i].setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/Entered"+c[i]+".png"));
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			this.add(colocables[i]);
//			x++;
		}
		int i=0;
		while(i<5){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45+(i/13)*20,65,65);
			i++;
			x++;
		}
		x=0;
		while(i<9){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45+(i/13)*20,65,65);
			i++;
			x++;
		}
		x=0;
		while(i<13){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45+(i/13)*20,65,65);
			i++;
			x++;
		}
		x=0;
		while(i<15){
			x=x%3;
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45+(i/13)*20,65,65);
			i++;
			x++;
		}
	}
	private void crearEtiquetas(int ancho, int alto){
		cantidades = new JLabel[4];
		int[] fila = {5,5,5,6};
		int x=0;
		for(int i=0;i<cantidades.length;i++){
			cantidades[i] = new JLabel();
			cantidades[i].setBorder(null);
			cantidades[i].setForeground(Color.WHITE);
			x=x%3;
			cantidades[i].setBounds(x*65+(x+1)*3,fila[i]*alto/12+(fila[i])*7+42,65,20);
			cantidades[i].setFocusable(false);
			cantidades[i].setText(c[i+9]+" x"+itemsPremio.get(c[i+9]));
			cantidades[i].setFont(new Font("Arial",Font.ITALIC,12));
			this.add(cantidades[i]);
			x++;
		}
	}
	private void otrasEtiquetas(int ancho, int alto){
		JLabel etiquetaShop = new JLabel(new ImageIcon("src/Sprites/IconosBotones/ShopEtiqueta.png"));
		etiquetaShop.setBounds(0,4,90,47);
		JLabel etiquetaPremios = new JLabel(new ImageIcon("src/Sprites/IconosBotones/PremiosEtiqueta.png"));
		etiquetaPremios.setBounds(0,alto/12*5+20,210,47);
		JLabel fondo = new JLabel(new ImageIcon("src/Sprites/IconosBotones/FondoMercado.png"));
		fondo.setBounds(0, 0, ancho/17*3, alto-100);
		add(etiquetaShop);
		add(etiquetaPremios);
		add(fondo);
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			String[] aux = {"Bomba x"+itemsPremio.get("Bomba"),"Booster x"+itemsPremio.get("Booster"),
			"Trampa x"+itemsPremio.get("Trampa"),"Escudo x"+itemsPremio.get("Escudo")};
			switch(s){
				case("Swordman"):{
					almacen.asignarAccion(new CreadorSwordman());
					
					break;
				}
				case("Arquero"):{
					almacen.asignarAccion(new CreadorArquero());
					break;
				}
				case("Angel"):{
					almacen.asignarAccion(new CreadorAngel());
					break;
				}
				case("Catapulta"):{
					almacen.asignarAccion(new CreadorCatapulta());
					break;
				}
				case("Mago"):{
					almacen.asignarAccion(new CreadorMago());
					break;
				}
				case("Barricada"):{
					almacen.asignarAccion(new CreadorBarricada());
					break;
				}
				case("Stun"):{
					almacen.asignarAccion(new CreadorStun());
					break;
				}
				case("Gusano"):{
					almacen.asignarAccion(new CreadorAgujeroGusano());
					break;
				}
				case("Curacion"):{
					almacen.asignarAccion(new CreadorCuracion());
					break;
				}
				case("Venta"):{
					almacen.asignarAccion(new Venta());
					break;
				}
				case("Bomba"):{
					almacen.asignarAccion(new CreadorBomba());
					break;
				}
				case("Booster"):{
					almacen.asignarAccion(new CreadorBooster());
					break;
				}
				case("Escudo"):{
					almacen.asignarAccion(new CreadorEscudo());
					break;
				}
				case("Upgrade"):{
					almacen.asignarAccion(new CreadorUpgrade());
					break;
				}
				case("Cancelar"):{
					almacen.asignarAccion(null);
					break;
				}
			}
		}
	}
}