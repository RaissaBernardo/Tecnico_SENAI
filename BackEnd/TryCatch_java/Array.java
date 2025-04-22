package aula14_11TRYCATCH;

import java.util.ArrayList;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int al[] = {1, 2, 3, 4, 5, 6};

		System.out.println("Digite um número de índice (0 a 5)");
		int indi = tec.nextInt();
		
	    try {
			System.out.println(al[indi]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: Texto inválido! Digite um número de 0 a 5");
		}
	   
	}

}
