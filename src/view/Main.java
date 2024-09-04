package view;

import java.util.Scanner;
import controller.ThreadSapo;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entre com a distância máxima da corrida");
		int distCorrida = scan.nextInt();
		for(int i = 0; i < 5; i++) {
			
			Thread t = new ThreadSapo(distCorrida, (i+1));
			t.start();
		}
		
		scan.close();
	}

}
