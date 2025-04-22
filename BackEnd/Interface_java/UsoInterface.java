package aula8_interface;

public class UsoInterface implements InterfacePai {
	//atributos
	public String a;
	
	//met construtor
	public UsoInterface() {
		System.out.println("Nasci");
	}
	
	@Override
	public void metodo1() {
		System.out.println("Chamei método 1");
	}
	
	@Override
	public void metedo2() {
		System.out.println("Chamei método 2");
	}
}
