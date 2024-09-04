package controller;

import java.util.Random;
public class ThreadSapo extends Thread {
	
	final int distPulo;
	final int distCorrida;
	int sapo;
	static int posicao = 1;
	static int[][] matrizPos = new int[2][5];
	
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
			int pulo = rand.nextInt(distPulo);
				
			System.out.println("Sapo " + sapo + " pulou " + pulo + " metros");
			pulou += pulo;
		}
		
		System.out.println("\nO sapo " + sapo + " chegou em " + posicao + "°\n");
		++posicao;
		
	}
}