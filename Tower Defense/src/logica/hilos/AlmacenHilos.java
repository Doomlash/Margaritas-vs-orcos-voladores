package logica.hilos;

import logica.comprables.Stun;
import logica.hilos.hilosAliado.*;
import logica.hilos.hilosEnemigo.*;
import logica.hilos.hilosPowerUpYPremios.*;

public class AlmacenHilos{
	private HiloMovimientoEnemigo movEnemigo;
	private HiloAtaqueEnemigo ataqueEnemigo;
	private HiloAtaqueAliado ataqueAliado;
	private HiloDisparoEnemigo disparosEnemigos;
	private HiloDisparoAliado disparosAliados;
	private HiloItemsPremio itemsPremio;
	private Stun stun;
	private HiloPowerUps powerUps;
	private HiloBombas bombas;
	private HiloMuertesGraficas muertes;
	private HiloTrampas trampas;
	private HiloAgua agua;
	private boolean ejecutando=true;
	
	public HiloMovimientoEnemigo getMovEnemigo(){
		if(movEnemigo==null){
			movEnemigo = new HiloMovimientoEnemigo();
			if(ejecutando)
				movEnemigo.start();
		}
		return movEnemigo;
	}
	public HiloAtaqueEnemigo getAtaEnemigo(){
		if(ataqueEnemigo==null){
			ataqueEnemigo = new HiloAtaqueEnemigo();
			if(ejecutando)
				ataqueEnemigo.start();
		}
		return ataqueEnemigo;
	}
	public HiloAtaqueAliado getAtaAliado(){
		if(ataqueAliado==null){
			ataqueAliado = new HiloAtaqueAliado();
			if(ejecutando)
				ataqueAliado.start();
		}
		return ataqueAliado;
	}
	public HiloDisparoEnemigo getDisEnemigo(){
		if(disparosEnemigos==null){
			disparosEnemigos = new HiloDisparoEnemigo();
			if(ejecutando)
				disparosEnemigos.start();
		}
		return disparosEnemigos;
	}
	public HiloDisparoAliado getDisAliado(){
		if(disparosAliados==null){
			disparosAliados = new HiloDisparoAliado();
			if(ejecutando)
				disparosAliados.start();
		}
		return disparosAliados;
	}
	public HiloItemsPremio getItemsPremio(){
		if(itemsPremio==null){
			itemsPremio = new HiloItemsPremio();
			if(ejecutando)
				itemsPremio.start();
		}
		return itemsPremio;
	}
	public void asignarStun(Stun s){
		if(stun!=null){
			stun.terminate();
		}
		stun=s;
		if(stun!=null){
			if(ejecutando)
				stun.start();
		}
	}
	public HiloPowerUps getPowerUps(){
		if(powerUps==null){
			powerUps = new HiloPowerUps();
			if(ejecutando)
				powerUps.start();
		}
		return powerUps;
	}
	public HiloBombas getBombas(){
		if(bombas==null){
			bombas = new HiloBombas();
			if(ejecutando)
				bombas.start();
		}
		return bombas;
	}
	public HiloMuertesGraficas getMuertesGraficas(){
		if(muertes==null){
			muertes = new HiloMuertesGraficas();
			if(ejecutando)
				muertes.start();
		}
		return muertes;
	}
	public HiloTrampas getTrampasAccionar(){
		if(trampas==null){
			trampas = new HiloTrampas();
			if(ejecutando)
				trampas.start();
		}
		return trampas;
	}
	public HiloAgua getAgua(){
		if(agua==null){
			agua = new HiloAgua();
			if(ejecutando)
				agua.start();
		}
		return agua;
	}
	public void terminateAll(){
		if(movEnemigo!=null)
			movEnemigo.terminate();
		if(ataqueEnemigo!=null)
			ataqueEnemigo.terminate();
		if(ataqueAliado!=null)
			ataqueAliado.terminate();
		if(disparosEnemigos!=null)
			disparosEnemigos.terminate();
		if(disparosAliados!=null)
			disparosAliados.terminate();
		if(itemsPremio!=null)
			itemsPremio.terminate();
		if(stun!=null)
			stun.terminate();
		if(powerUps!=null)
			powerUps.terminate();
		if(bombas!=null)
			bombas.terminate();
		if(muertes!=null)
			muertes.terminate();
		if(trampas!=null)
			trampas.terminate();
		if(agua!=null)
			agua.terminate();
		ejecutando=false;
	}
	public void pausar(){
		if(movEnemigo!=null)
			movEnemigo.pausar();
		if(ataqueEnemigo!=null)
			ataqueEnemigo.pausar();
		if(ataqueAliado!=null)
			ataqueAliado.pausar();
		if(disparosEnemigos!=null)
			disparosEnemigos.pausar();
		if(disparosAliados!=null)
			disparosAliados.pausar();
		if(itemsPremio!=null)
			itemsPremio.pausar();
		if(stun!=null)
			stun.pausar();
		if(powerUps!=null)
			powerUps.pausar();
		if(bombas!=null)
			bombas.pausar();
		if(trampas!=null)
			trampas.pausar();
		if(agua!=null)
			agua.pausar();
	}
	public void reanudar(){
		if(movEnemigo!=null)
			movEnemigo.reanudar();
		if(ataqueEnemigo!=null)
			ataqueEnemigo.reanudar();
		if(ataqueAliado!=null)
			ataqueAliado.reanudar();
		if(disparosEnemigos!=null)
			disparosEnemigos.reanudar();
		if(disparosAliados!=null)
			disparosAliados.reanudar();
		if(itemsPremio!=null)
			itemsPremio.reanudar();
		if(stun!=null)
			stun.reanudar();
		if(powerUps!=null)
			powerUps.reanudar();
		if(bombas!=null)
			bombas.reanudar();
		if(trampas!=null)
			trampas.reanudar();
		if(agua!=null)
			agua.reanudar();
	}
}