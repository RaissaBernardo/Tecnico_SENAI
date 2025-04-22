package aula9_associacao;

import java.util.ArrayList;
import java.util.List;

public class TesteBiblioteca {

	public static void main(String[] args) {
		//instranciando objs da classe livro
		Livro_ex3 l1 = new Livro_ex3("Programação JAVA", "Deitel");
		Livro_ex3 l2 = new Livro_ex3("UML", "Bezerra");
		
		//instanciando lista vazia para adicionar os livros 
		List<Livro_ex3> liv = new ArrayList<Livro_ex3>();
		
		//add livros na lista
		liv.add(l1);
		liv.add(l2);
		
		//instanciando obj biblioteca p add a lista de Livros
		Biblioteca_ex3 biblio = new Biblioteca_ex3(liv);
		List<Livro_ex3> li = biblio.getTotalLivrosBiblioteca();
		
		//varrer a lista de livros q ja estão na biblioteca
		for(Livro_ex3 olho : li) {
			System.out.println("Título: " + olho.titulo + " Autor: " + olho.autor);
			System.out.println("Li: " + li.get(0));
		}

	}

}
