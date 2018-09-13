package br.com.cursojava.aula004;

import java.util.Scanner;

public class ExemploIf {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite sua idade");
		int idade = Integer.parseInt(teclado.nextLine());
		if( idade >= 18 ){
			System.out.println("Você é Obrigado a votar!!!");
		} else {
			System.out.println("Você Não vota!");
		}
		System.out.println("Fim da aplicação");
		teclado.close();
	}
	

}
