package aula14_11TRYCATCH;

import java.util.Scanner;

public class IntEString {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		boolean entrar = true;

		while(entrar) {
			System.out.println("Digite um número inteiro:");
			
			try {
				String add = tec.nextLine();
	
	            int num = Integer.parseInt(add);
	            
	            System.out.println("Número convertido: " + num);
	            entrar = false;
	            
			} catch (NumberFormatException e) {
				System.out.println("Erro: Texto inválido! Digite um número inteiro.");
			}
		}

	}

}
