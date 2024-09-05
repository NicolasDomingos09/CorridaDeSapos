package controller;

import java.util.Random;
public class ThreadSapo extends Thread {
	
	final int distPulo;
	final int distCorrida;
	int sapo;
	
	//Variáveis para manipulação interna
	static int posicao = 1;
	static int[] podio = new int[5];
	
	public ThreadSapo(int distCorrida, int sapo) {
		this.distCorrida = distCorrida;
		this.distPulo = (int)(distCorrida*0.1);
		this.sapo = sapo;
	}
	
	@Override
	public void run() {
		correSapo(distCorrida, distPulo, sapo);
		
	}
	
	private void correSapo(int distCorrida, int distPulo, int sapo) {
		Random rand = new Random();
		int pulou = 0;
		
		while(pulou < distCorrida) {
			int pulo = rand.nextInt(1,distPulo);
				
			System.out.println("Sapo " + sapo + " pulou " + pulo + " metros. Total percorrido: " + pulou);
			pulou += pulo;
			
			try {
				Thread.sleep(rand.nextInt(100,800));//Delay no sapo
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\nO sapo " + sapo + " terminou a corrida \n");
		
		podio(sapo);
		
		++posicao;	
	}
	
	private void podio(int sapo) {
		
		podio[posicao-1] = sapo;
		
		if(posicao >= 5) {
			
			System.out.println("***Pódio da corrida de sapos***");
			for (int i = 0; i < 5; i++) {
				System.out.println("O sapo " + podio[i] + " chegou em " + (i+1) + "°");
			}
		}
	}
}