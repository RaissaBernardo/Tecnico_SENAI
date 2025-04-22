package aula9_associacao;

public class TesteComposicao1 {

	public static void main(String[] args) {
		Pessoa_ex2 pes1 = new Pessoa_ex2("chefe", "Rita", 45);
		Empregado_ex2 empreg1 = new Empregado_ex2(2344, pes1);
		
		System.out.println("Cargo: " + pes1.cargo);
		System.out.println("Salário: " + empreg1.getSalario());
		
	}

}
