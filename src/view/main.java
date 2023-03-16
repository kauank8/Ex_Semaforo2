package view;

import java.util.concurrent.Semaphore;

import controller.CaminharController;

public class main {

	public static void main(String[] args) {
		Semaphore semaforo=new Semaphore(1);
		for(int i=0;i<4;i++) {
			Thread caminhar=new CaminharController(i, semaforo);
			caminhar.start();
		}

	}

}
