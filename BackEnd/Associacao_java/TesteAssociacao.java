package aula9_associacao;

public class TesteAssociacao {

	public static void main(String[] args) {
		Banco ban1 = new Banco("Banco do Brasil");
		Empregado emp1 = new Empregado("Julia");
		
		System.out.println(emp1.getNomeEmpregado() + " é empregada do " + ban1.getNomeBanco());

	}

}
