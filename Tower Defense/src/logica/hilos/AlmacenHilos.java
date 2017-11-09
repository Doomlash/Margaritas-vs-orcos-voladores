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
	private HiloInvocacionNigromante invocacion;
	
	public HiloMovimientoEnemigo getMovEnemigo(){
		if(movEnemigo==null){
			movEnemigo = new HiloMovimientoEnemigo();
			movEnemigo.start();
		}
		return movEnemigo;
	}
	public HiloAtaqueEnemigo getAtaEnemigo(){
		if(ataqueEnemigo==null){
			ataqueEnemigo = new HiloAtaqueEnemigo();
			ataqueEnemigo.start();
		}
		return ataqueEnemigo;
	}
	public HiloAtaqueAliado getAtaAliado(){
		if(ataqueAliado==null){
			ataqueAliado = new HiloAtaqueAliado();
			ataqueAliado.start();
		}
		return ataqueAliado;
	}
	public HiloDisparoEnemigo getDisEnemigo(){
		if(disparosEnemigos==null){
			disparosEnemigos = new HiloDisparoEnemigo();
			disparosEnemigos.start();
		}
		return disparosEnemigos;
	}
	public HiloDisparoAliado getDisAliado(){
		if(disparosAliados==null){
			disparosAliados = new HiloDisparoAliado();
			disparosAliados.start();
		}
		return disparosAliados;
	}
	public HiloItemsPremio getItemsPremio(){
		if(itemsPremio==null){
			itemsPremio = new HiloItemsPremio();
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
			stun.start();
		}
	}
	public HiloPowerUps getPowerUps(){
		if(powerUps==null){
			powerUps = new HiloPowerUps();
			powerUps.start();
		}
		return powerUps;
	}
	public HiloBombas getBombas(){
		if(bombas==null){
			bombas = new HiloBombas();
			bombas.start();
		}
		return bombas;
	}
	public HiloInvocacionNigromante getInvocacioNigromante(){
		if(invocacion==null){
			invocacion = new HiloInvocacionNigromante();
			invocacion.start();
		}
		return invocacion;
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
		if(invocacion!=null)
			invocacion.terminate();
	}
}