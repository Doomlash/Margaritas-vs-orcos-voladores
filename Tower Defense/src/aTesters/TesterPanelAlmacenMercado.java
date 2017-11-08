package aTesters;

import javax.swing.JPanel;

public class TesterPanelAlmacenMercado {
	private TesterPanelAlmacen almacen;
	private TesterPanelMercado mercado;
	
	public TesterPanelAlmacenMercado(int anchoGui, int altoGui){
		almacen = new TesterPanelAlmacen(anchoGui,altoGui);
		mercado = new TesterPanelMercado(anchoGui,altoGui);
	}
	
	public void agregarPaneles(JPanel contentPane){
		contentPane.add(almacen);
		contentPane.add(mercado);
	}
}