package aula14_11TRYCATCH;

import java.util.Scanner;

// Exceção minha
class DivZero extends Exception {
    public DivZero(String mensagem) {
        super(mensagem);
    }
}

public class Divisao {
    public Divisao() { 
    }

    //variação
    public void validaDivisao(float num1, float num2) throws DivZero {
        if (num2 == 0) {
            throw new DivZero("Não é possível dividir por 0");
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Divisao sist = new Divisao();
        System.out.println("DIVISÃO DE DOIS NÚMEROS");
        
        try {
            System.out.println("Digite o primeiro número:");
            float num1 = teclado.nextFloat();
            
            System.out.println("Digite o segundo número:");
            float num2 = teclado.nextFloat();

            sist.validaDivisao(num1, num2);

            float div = num1 / num2;
            System.out.println("Resultado: " + div);
            
        } catch (DivZero e) {
            System.out.println(e.getMessage()); //mensagem da exceção
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
