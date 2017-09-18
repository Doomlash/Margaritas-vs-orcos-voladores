package grafica.gui;

public class ContadorTiempo extends Thread {

	ContadorTiempo() {
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}