package br.com.cursojava.aula021;

import java.util.Scanner;

public class ExemploExcecoes {

	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
//		System.out.println("Digite um número:");
//		int numero = Integer.parseInt(teclado.nextLine());
//		System.out.println("O número digitado foi: "+numero);
		try{
		String[] nomes = {"João", "Maria"};
		System.out.println(Integer.parseInt("dois"));
		System.out.println(nomes[2]);
		
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException ex){
			ex.printStackTrace();
			System.out.println(ex);
			System.out.println("Você tentou acessar uma posição inválida!! ou a conversão não funcionou");
		}
		
		System.out.println("Código continuou normalmente");
		teclado.close();
	}
	
}
