package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CaminharController extends Thread {
	private int Pessoa;
	private Semaphore semaforo;
	
	public CaminharController(int Pessoa,Semaphore semaforo ) {
		this.Pessoa=Pessoa;
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		caminhar();
		try {
			semaforo.acquire();
			abrirporta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
			saida();
			
		}
		super.run();
	}
	
	public void caminhar(){
		int corredor=200;
		int tempo=1000;
		Random gerador = new Random();
		int caminhada=0;
		int acumulador=0;
		for(caminhada=gerador.nextInt(6)+4;acumulador<corredor;caminhada=gerador.nextInt(6)+4) {
			acumulador+=caminhada;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("A "+Pessoa+ " Pessoa chegou na porta do corredor ");
	}
	
	public void abrirporta() {
		Random gerador = new Random();
		int saida=gerador.nextInt(2000)+1000;
		try {
			sleep(saida);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A "+Pessoa+ " Pessoa abriu a porta");
	}
	
	public void saida() {
		System.out.println("A "+Pessoa+ " Pessoa cruzou a porta");
	}

}
