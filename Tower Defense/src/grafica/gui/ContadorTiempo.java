package grafica.gui;

public class ContadorTiempo extends Thread {
	private GUI gui;	
	
	public ContadorTiempo(GUI g){
		gui=g;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(500);
				gui.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}