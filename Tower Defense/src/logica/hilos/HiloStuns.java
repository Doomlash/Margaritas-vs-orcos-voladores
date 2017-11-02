package logica.hilos;

import logica.comprables.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HiloStuns extends Thread{
	private volatile boolean execute;
	private Map<Integer,Stun> stuns;
	private List<Stun> toInsert;
	private AlmacenHilos hilos;
	
	public HiloStuns(AlmacenHilos h){
		hilos = h;
		execute=true;
		stuns = new HashMap<Integer,Stun>();
		toInsert = new ArrayList<Stun>();
	}
	public void agregarStun(Stun s){
		toInsert.add(s);
	}
	public void terminate(){
		execute=false;
	}
//	public void run(){
//		while(execute){
//			int y = toInsert.size();
//			for(int i=0;i<y;i++){
//				Stun s = toInsert.remove(0);
//				stuns.put(s.filaAfectada(), s);
//				hilos.getAtaEnemigo().afectarFila(s.filaAfectada());
//			}
//			int x= stuns.size();
//			if(x>0){
//				try{
//					Thread.sleep(1000);
//				}catch(InterruptedException e){
//				}
//				for(Stun s: stuns.values()){
//					s.reducirTemporizador();
//					if(s.getTiempo()<=0){
//						stuns.remove(s.filaAfectada());
//						hilos.getAtaEnemigo().desafectarFila(s.filaAfectada());
//					}
//				}
//			}
//		}
//	}
}
