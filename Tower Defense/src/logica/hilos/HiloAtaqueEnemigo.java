package logica.hilos;

public class HiloAtaqueEnemigo extends HiloEnemigo{
	
	public HiloAtaqueEnemigo(){
		super();
	}
	public void run(){
		while(execute){
			actualizar();
			int x= toExecute.size();
			for(int i=0;i<x;i++){
				toExecute.get(i).atacarRango();
				try{
					Thread.sleep(150/x);
				}catch(InterruptedException e){
				}
			}
		}
	}
}