package aula8_interface;

public class TesteControle {

	public static void main(String[] args) {
		Tv tv1 = new Tv();
		ControleRemoto cont = new Tv();
		
		cont.ligar();
		cont.volumeMais(10);
		cont.volumeMenos(11);
		cont.desliga();
		cont.getPolegada(0);
		System.out.println("As polegadas são: " + cont.getPolegada(0));

	}

}
