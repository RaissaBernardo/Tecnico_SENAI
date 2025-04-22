package aula9_associacao;

import java.util.List;

public class Biblioteca_ex3 {
	//atri
	private final List<Livro_ex3> livros; //composição
	
	//const
	Biblioteca_ex3(List<Livro_ex3> livros) {
		this.livros = livros;
	}
	
	//met
	public List<Livro_ex3> getTotalLivrosBiblioteca(){
		return livros;
	}
	
	
	
}
