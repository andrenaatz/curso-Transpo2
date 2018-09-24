package br.com.cursojava.aula011;

public class App {

	public static void main(String[] args) {
		
		Contato abacaxi = new Contato();
		
		abacaxi.nome = "João";
		abacaxi.email = "joao@teste.com";
		abacaxi.telefone = "33221100";
		
		System.out.println(abacaxi.nome);
		System.out.println(abacaxi.email);
		System.out.println(abacaxi.telefone);
		
		abacaxi.configuraNome("João da Silva");
		System.out.println(abacaxi.retornaNome());
		System.out.println(abacaxi.nome);
		
		abacaxi.ligar();

	}
	
}
