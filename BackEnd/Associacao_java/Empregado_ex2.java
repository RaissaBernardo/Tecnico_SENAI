package aula9_associacao;

public class Empregado_ex2 {
	private int salario;
	private Pessoa_ex2 funcionario; //composição
	
	public Empregado_ex2(int salario, Pessoa_ex2 funcionario) {
		this.salario = salario;
		this.funcionario = funcionario;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Pessoa_ex2 getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa_ex2 funcionario) {
		this.funcionario = funcionario;
	}
	
}
